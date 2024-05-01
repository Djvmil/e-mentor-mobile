package com.djvmil.entretienmentor.core.domain.usecase

import com.djvmil.entretienmentor.core.domain.model.InputRegister
import com.djvmil.entretienmentor.core.domain.model.RegisterInputValidationType
import com.djvmil.entretienmentor.core.domain.util.UseCase
import com.djvmil.entretienmentor.core.domain.util.containsNumber
import com.djvmil.entretienmentor.core.domain.util.containsSpecialChar
import com.djvmil.entretienmentor.core.domain.util.containsUpperCase

class ValidateRegisterInputUseCase: UseCase<InputRegister, RegisterInputValidationType> {

    override suspend operator fun invoke(input: InputRegister): RegisterInputValidationType {


        if (input.emailInput.isEmpty() || input.passwordInput.isEmpty() || input.passwordRepeatedInput.isEmpty()) {
            return RegisterInputValidationType.EmptyField
        }
        if ("@" !in input.emailInput) {
            return RegisterInputValidationType.NoEmail
        }
        if (input.passwordInput != input.passwordRepeatedInput) {
            return RegisterInputValidationType.PasswordDoNotMatch
        }
        if (input.passwordInput.count() < 8) {
            return RegisterInputValidationType.PasswordTooShort
        }
        if (!input.passwordInput.containsNumber()) {
            return RegisterInputValidationType.PasswordNumberMissing
        }
        if (!input.passwordInput.containsUpperCase()){
            return RegisterInputValidationType.PasswordUpperCaseMissing
        }
        if (!input.passwordInput.containsSpecialChar()){
            return RegisterInputValidationType.PasswordSpecialCharMissing
        }
        return RegisterInputValidationType.Valid
    }

}