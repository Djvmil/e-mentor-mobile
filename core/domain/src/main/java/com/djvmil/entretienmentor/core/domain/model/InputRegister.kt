package com.djvmil.entretienmentor.core.domain.model

data class InputRegister (
    val firstnameInput: String = "",
    val lastnameInput: String = "",
    val phoneNumberInput: String = "",
    val emailInput: String = "",
    val passwordInput: String = "",
    val passwordRepeatedInput: String = "",
    val isInputValid: Boolean = false

)