package com.djvmil.data.model.auth

import com.squareup.moshi.Json

data class Data(
    @field:Json(name = "id")
    var id: Int? = null,

    @field:Json(name = "email")
    var email: String? = null,

    @field:Json(name = "firstname")
    var firstName: String? = null,

    @field:Json(name = "lastname")
    var lastName: String? = null,

    @field:Json(name = "avatar")
    var avatar: String? = null

)