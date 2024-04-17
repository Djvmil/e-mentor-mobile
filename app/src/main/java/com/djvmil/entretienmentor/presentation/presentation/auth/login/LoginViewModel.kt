package com.djvmil.entretienmentor.presentation.presentation.auth.login

import androidx.lifecycle.ViewModel
import com.djvmil.domain.usecase.LoginUseCase
import kotlinx.coroutines.CoroutineDispatcher

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel()  {




}