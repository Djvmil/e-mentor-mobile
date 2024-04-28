package com.djvmil.entretienmentor.core.domain.model

enum class RegisterInputValidationType {
    EmptyField,
    NoFirstname,
    NoLastname,
    NoPhoneNumber,
    NoEmail,
    PasswordDoNotMatch,
    PasswordUpperCaseMissing,
    PasswordNumberMissing,
    PasswordSpecialCharMissing,
    PasswordTooShort,
    Valid
}