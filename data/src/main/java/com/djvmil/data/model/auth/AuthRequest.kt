package com.djvmil.data.model.auth

import kotlinx.serialization.SerialName

data class AuthRequest(
    @SerialName("id")
    var id: Int? = null,
    @SerialName("email")
    var email: String? = null,
    @SerialName("first_name")
    var firstName: String? = null,
    @SerialName("last_name")
    var lastName: String? = null,
    @SerialName("avatar")
    var avatar: String? = null,
    @SerialName("password")
    var password: String? = null

)