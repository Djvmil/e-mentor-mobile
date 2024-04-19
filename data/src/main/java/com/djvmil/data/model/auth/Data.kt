package com.djvmil.data.model.auth

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    var id: Int? = null,
    var email: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var avatar: String? = null

)