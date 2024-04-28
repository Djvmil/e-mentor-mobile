package com.djvmil.entretienmentor.feature.ui

data class TextFieldState(
    val text :  String? = null,
    val error: String? = null,
    val readOnly: Boolean = false,
    val trailingIcon: Int? = null,
    val leadingIcon: Int? = null,
)