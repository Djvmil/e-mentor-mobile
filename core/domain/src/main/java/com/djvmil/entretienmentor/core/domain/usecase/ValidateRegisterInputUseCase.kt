package com.djvmil.entretienmentor.core.domain.usecase

import com.djvmil.entretienmentor.core.domain.model.InputRegister
import com.djvmil.entretienmentor.core.domain.model.RegisterInputValidationType
import com.djvmil.entretienmentor.core.domain.util.UseCase
import com.djvmil.entretienmentor.core.domain.util.containsNumber
import com.djvmil.entretienmentor.core.domain.util.containsSpecialChar
import com.djvmil.entretienmentor.core.domain.util.containsUpperCase

class ValidateRegisterInputUseCase: UseCase<InputRegister, RegisterInputValidationType> {

    override suspend operator fun invoke(inputRegister: InputRegister): RegisterInputValidationType {


        if (inputRegister.emailInput.isEmpty() || inputRegister.passwordInput.isEmpty() || inputRegister.passwordRepeatedInput.isEmpty()) {
            return RegisterInputValidationType.EmptyField
        }
        if ("@" !in inputRegister.emailInput) {
            return RegisterInputValidationType.NoEmail
        }
        if (inputRegister.passwordInput != inputRegister.passwordRepeatedInput) {
            return RegisterInputValidationType.PasswordDoNotMatch
        }
        if (inputRegister.passwordInput.count() < 8) {
            return RegisterInputValidationType.PasswordTooShort
        }
        if (!inputRegister.passwordInput.containsNumber()) {
            return RegisterInputValidationType.PasswordNumberMissing
        }
        if (!inputRegister.passwordInput.containsUpperCase()){
            return RegisterInputValidationType.PasswordUpperCaseMissing
        }
        if (!inputRegister.passwordInput.containsSpecialChar()){
            return RegisterInputValidationType.PasswordSpecialCharMissing
        }
        return RegisterInputValidationType.Valid
    }

}