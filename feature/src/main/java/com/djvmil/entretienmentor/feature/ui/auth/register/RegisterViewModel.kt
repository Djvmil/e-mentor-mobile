package com.djvmil.entretienmentor.feature.ui.auth.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.djvmil.entretienmentor.core.common.dispatcher.AppDispatchers
import com.djvmil.entretienmentor.core.common.model.ResultEM
import com.djvmil.entretienmentor.core.data.model.auth.AuthRequest
import com.djvmil.entretienmentor.core.domain.model.InputRegister
import com.djvmil.entretienmentor.core.domain.model.RegisterInputValidationType
import com.djvmil.entretienmentor.core.domain.usecase.RegisterUseCase
import com.djvmil.entretienmentor.core.domain.usecase.ValidateRegisterInputUseCase
import com.djvmil.entretienmentor.feature.ui.auth.login.model.RegisterState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RegisterViewModel (
    private val registerUseCase: RegisterUseCase,
    private val dispatchers: AppDispatchers,
    private val validateRegisterInputUseCase: ValidateRegisterInputUseCase
) : ViewModel()  {
    var registerState by mutableStateOf(RegisterState())
        private set

    fun onRegisterClick() = viewModelScope.launch(dispatchers.io) {
        registerUseCase.invoke(
            AuthRequest(username = registerState.usernameInput, password = registerState.passwordInput)
        ).collect { result->
            registerState = registerState.copy(isLoading = true)
            delay(4000)
            registerState = when(result){
                is ResultEM.Loading -> {
                    registerState.copy(isLoading = true)
                }
                is ResultEM.Success -> {
                    registerState.copy(
                        isLoading = false,
                        isSuccessfullyLoggedIn = true
                    )
                }
                is ResultEM.Failure -> {
                    registerState.copy(
                        isLoading = false,
                        isSuccessfullyLoggedIn = false,
                        errorMessageLoginProcess = result.error.throwable?.message
                    )
                }
            }

        }
    }

    fun onUsernameInputChange(newValue: String) = viewModelScope.launch(dispatchers.io) {
        registerState = registerState.copy(usernameInput = newValue)
        checkInputValidation()
    }
    fun onPasswordInputChange(newValue: String) = viewModelScope.launch(dispatchers.io) {
        registerState = registerState.copy(passwordInput = newValue)
        checkInputValidation()
    }

    private suspend fun checkInputValidation() {
        val validationResult = validateRegisterInputUseCase(
            InputRegister(
                emailInput = registerState.usernameInput,
                passwordInput = registerState.passwordInput
            )
        )
        processInputValidationType(validationResult)
    }

    private fun processInputValidationType(type: RegisterInputValidationType) {
        registerState = when (type) {
            RegisterInputValidationType.EmptyField -> {
                registerState.copy(errorMessageLoginProcess = "Empty fields left", isInputValid = false)
            }
            RegisterInputValidationType.NoEmail -> {
                registerState.copy(errorUsernameInput = "No valid username", isInputValid = false)
            }
            RegisterInputValidationType.Valid -> {
                registerState.copy(errorMessageLoginProcess = null, isInputValid = true)
            }
            else ->{ registerState.copy(errorMessageLoginProcess = null, isInputValid = true) }
        }
    }
}