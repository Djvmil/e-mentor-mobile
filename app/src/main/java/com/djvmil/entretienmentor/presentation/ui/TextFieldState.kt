package com.djvmil.entretienmentor.presentation.ui

data class TextFieldState(
    val text :  String? = null,
    val error: String? = null,
    val readOnly: Boolean = false,
    val icon: Int? = null,
)