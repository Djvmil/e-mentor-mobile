package com.djvmil.data.model.auth

import com.djvmil.core.ResultEM

data class AuthResult(
    val passwordError: String? = null,
    val emailError : String? = null,
    //val result: ResultEM<Unit>? = null
)