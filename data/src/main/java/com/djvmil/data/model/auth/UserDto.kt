package com.djvmil.data.model.auth

import kotlinx.serialization.SerialName

data class UserDto(

    @SerialName("data")
    var data: Data? = Data(),
    @SerialName("support")
    var support: Support? = Support()

)