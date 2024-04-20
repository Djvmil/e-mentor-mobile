package com.djvmil.data.model.auth

import com.djvmil.data.source.api.model.UserApiModel
import kotlinx.serialization.Serializable

@Serializable
data class ResponseAuthData(
	val user: UserApiModel? = null,
	val accesToken: String? = null
)
