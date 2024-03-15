package com.djvmil.data.model.auth

import kotlinx.serialization.SerialName

data class Support (

    @SerialName("url"  )
    var url  : String? = null,
    @SerialName("text" )
    var text : String? = null

)