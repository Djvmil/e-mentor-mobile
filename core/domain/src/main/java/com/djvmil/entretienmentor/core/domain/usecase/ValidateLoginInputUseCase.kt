package com.djvmil.entretienmentor.core.domain.usecase

import com.djvmil.entretienmentor.core.domain.model.InputLogin
import com.djvmil.entretienmentor.core.domain.model.LoginInputValidationType
import com.djvmil.entretienmentor.core.domain.util.UseCase

class ValidateLoginInputUseCase : UseCase<InputLogin, LoginInputValidationType> {
    override suspend fun invoke(input: InputLogin): LoginInputValidationType {
        if (input.usernameInput.isEmpty() || input.passwordInput.isEmpty()) {
            return LoginInputValidationType.EmptyField
        }
        if ("@" !in input.usernameInput) {
            return LoginInputValidationType.NoUsername
        }
        return LoginInputValidationType.Valid
    }
}