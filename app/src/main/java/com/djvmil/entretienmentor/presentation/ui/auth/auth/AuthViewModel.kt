package com.djvmil.entretienmentor.presentation.ui.auth.auth

import androidx.lifecycle.ViewModel
import com.djvmil.domain.usecase.LoginUseCase
import com.djvmil.domain.usecase.RegisterUseCase

class AuthViewModel(
    private val registerUseCase: RegisterUseCase,
    private val loginUseCase: LoginUseCase
) : ViewModel()  {

}