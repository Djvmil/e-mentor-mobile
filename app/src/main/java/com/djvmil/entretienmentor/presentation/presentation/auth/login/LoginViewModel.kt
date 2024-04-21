package com.djvmil.entretienmentor.presentation.presentation.auth.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.djvmil.core.ResultEM
import com.djvmil.core.di.AppDispatchers
import com.djvmil.data.model.auth.AuthRequest
import com.djvmil.data.source.datastore.AppSettingsDataStoreSource
import com.djvmil.domain.usecase.GetMovieUseCase
import com.djvmil.domain.usecase.LoginUseCase
import com.djvmil.entretienmentor.presentation.presentation.ScreenUiState
import com.djvmil.entretienmentor.presentation.presentation.TextFieldState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    private val getMovieUseCase: GetMovieUseCase,
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

