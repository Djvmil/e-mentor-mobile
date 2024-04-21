package com.djvmil.entretienmentor.presentation.presentation.auth.register

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import com.djvmil.domain.usecase.RegisterUseCase
import com.djvmil.entretienmentor.presentation.presentation.TextFieldState
import kotlinx.coroutines.CoroutineDispatcher



@OptIn(ExperimentalFoundationApi::class)
class RegisterViewModel (
    private val registerUseCase: RegisterUseCase,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel()  {
    private val _emailState = mutableStateOf(TextFieldState())
    val emailState: State<TextFieldState> = _emailState

    fun setEmail(value:String){
        _emailState.value = emailState.value.copy(text = value)
    }
}