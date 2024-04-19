package com.djvmil.data.model.auth

import kotlinx.serialization.Serializable

@Serializable
data class AuthResult<T>(
    var code: Int? = null,
    var status: String? = null,
    var message: String? = null,
    var data: T? = null,
    var timestamp: String? = null
)