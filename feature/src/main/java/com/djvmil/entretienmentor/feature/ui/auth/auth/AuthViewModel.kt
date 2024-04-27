package com.djvmil.entretienmentor.feature.ui.auth.auth

import androidx.lifecycle.ViewModel
import com.djvmil.entretienmentor.core.domain.usecase.LoginUseCase
import com.djvmil.entretienmentor.core.domain.usecase.RegisterUseCase

class AuthViewModel(
    private val registerUseCase: RegisterUseCase,
    private val loginUseCase: LoginUseCase
) : ViewModel()  {

}