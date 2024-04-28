package com.djvmil.entretienmentor.feature.ui.auth.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.djvmil.entretienmentor.core.common.dispatcher.AppDispatchers
import com.djvmil.entretienmentor.core.common.model.ResultEM
import com.djvmil.entretienmentor.core.data.model.auth.AuthRequest
import com.djvmil.entretienmentor.core.data.source.datastore.AppSettingsDataStoreSource
import com.djvmil.entretienmentor.core.domain.model.InputLogin
import com.djvmil.entretienmentor.core.domain.model.LoginInputValidationType
import com.djvmil.entretienmentor.core.domain.usecase.LoginUseCase
import com.djvmil.entretienmentor.core.domain.usecase.ValidateLoginInputUseCase
import com.djvmil.entretienmentor.feature.ui.auth.login.model.RegisterState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    private val validateLoginInputUseCase: ValidateLoginInputUseCase,
    private val dispatchers: AppDispatchers,
    private val dataStoreSource: AppSettingsDataStoreSource
) : ViewModel()  {
    var loginState by mutableStateOf(RegisterState())
        private set

    fun onLoginClick() = viewModelScope.launch(dispatchers.io) {
        loginUseCase.invoke(
            AuthRequest(username = loginState.usernameInput, password = loginState.passwordInput)
        ).collect { result->
            loginState = loginState.copy(isLoading = true)
            delay(4000)
            loginState = when(result){
                is ResultEM.Loading -> {
                    loginState.copy(isLoading = true)
                }
                is ResultEM.Success -> {
                    loginState.copy(
                        isLoading = false,
                        isSuccessfullyLoggedIn = true
                    )
                }
                is ResultEM.Failure -> {
                    loginState.copy(
                        isLoading = false,
                        isSuccessfullyLoggedIn = false,
                        errorMessageLoginProcess = result.error.throwable?.message
                    )
                }
            }

        }
    }

    fun onUsernameInputChange(newValue: String) = viewModelScope.launch(dispatchers.io) {
        loginState = loginState.copy(usernameInput = newValue)
        checkInputValidation()
    }
    fun onPasswordInputChange(newValue: String) = viewModelScope.launch(dispatchers.io) {
        loginState = loginState.copy(passwordInput = newValue)
        checkInputValidation()
    }

    private suspend fun checkInputValidation() {
        val validationResult = validateLoginInputUseCase(
            InputLogin(
                loginState.usernameInput,
                loginState.passwordInput
            )
        )
        processInputValidationType(validationResult)
    }

    private fun processInputValidationType(type: LoginInputValidationType) {
        loginState = when (type) {
            LoginInputValidationType.EmptyField -> {
                loginState.copy(errorMessageLoginProcess = "Empty fields left", isInputValid = false)
            }
            LoginInputValidationType.NoUsername -> {
                loginState.copy(errorUsernameInput = "No valid username", isInputValid = false)
            }
            LoginInputValidationType.Valid -> {
                loginState.copy(errorMessageLoginProcess = null, isInputValid = true)
            }
        }
    }
}

