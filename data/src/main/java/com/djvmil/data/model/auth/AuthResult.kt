package com.djvmil.data.model.auth

import com.squareup.moshi.Json

data class AuthResult<T>(
    @field:Json(name = "code")
    var code: Int? = null,
    @field:Json(name = "status")
    var status: String? = null,
    @field:Json(name = "message")
    var message: String? = null,
    @field:Json(name = "data")
    var data: T? = null,
    @field:Json(name = "timestamp")
    var timestamp: String? = null
)