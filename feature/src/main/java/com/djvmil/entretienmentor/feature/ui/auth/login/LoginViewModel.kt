package com.djvmil.entretienmentor.feature.ui.auth.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.djvmil.entretienmentor.core.common.dispatcher.AppDispatchers
import com.djvmil.entretienmentor.core.common.model.ResultEM
import com.djvmil.entretienmentor.core.data.model.auth.AuthRequest
import com.djvmil.entretienmentor.core.data.source.datastore.AppSettingsDataStoreSource
import com.djvmil.entretienmentor.core.domain.usecase.GetCommunityUseCase
import com.djvmil.entretienmentor.core.domain.usecase.LoginUseCase
import com.djvmil.entretienmentor.feature.ui.ScreenUiState
import com.djvmil.entretienmentor.feature.ui.TextFieldState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    private val getMovieUseCase: GetCommunityUseCase,
    private val dispatchers: AppDispatchers,
    private val dataStoreSource: AppSettingsDataStoreSource
) : ViewModel()  {

    private val _uiState  = MutableStateFlow<ScreenUiState<String>>(ScreenUiState.Loading)
    val uiState =  _uiState


    private val _firstName = mutableStateOf(TextFieldState())
    val firstName: State<TextFieldState> = _firstName

    fun setFirstName(value:String){
        _firstName.value = firstName.value.copy(text = value)
    }

    private val _lastName = mutableStateOf(TextFieldState())
    val lastName: State<TextFieldState> = _lastName

    fun setLastName(value:String){
        _lastName.value = lastName.value.copy(text = value)
    }

    private val _emailState = mutableStateOf(TextFieldState())
    val emailState: State<TextFieldState> = _emailState

    fun setEmail(value:String){
        _emailState.value = emailState.value.copy(text = value)
    }

    private val _passwordState = mutableStateOf(TextFieldState())
    val passwordState: State<TextFieldState> = _passwordState

    fun setPassword(value:String){
        _passwordState.value = passwordState.value.copy(text = value)
    }


fun login() = viewModelScope.launch(dispatchers.io) {
    _uiState.emit(ScreenUiState.Loading)

    loginUseCase.invoke(AuthRequest(username = "admin@em.com", password = "1234")).collect { result->
            when(result){
                is ResultEM.Loading -> {
                    _uiState.emit(ScreenUiState.Loading)
                }
                is ResultEM.Success -> {
                    _uiState.emit(ScreenUiState.Success(result.value.message!!))}
                is ResultEM.Failure -> {
                    _uiState.emit(ScreenUiState.Failure(result.error.throwable!!))}

                }
            }

    }
}

