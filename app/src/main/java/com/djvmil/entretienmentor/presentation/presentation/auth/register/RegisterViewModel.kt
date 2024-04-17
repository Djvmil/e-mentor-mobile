package com.djvmil.entretienmentor.presentation.presentation.auth.register

import androidx.lifecycle.ViewModel
import com.djvmil.domain.usecase.RegisterUseCase
import kotlinx.coroutines.CoroutineDispatcher

class RegisterViewModel (
    private val registerUseCase: RegisterUseCase,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel()  {

}