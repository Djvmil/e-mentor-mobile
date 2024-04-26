package com.djvmil.entretienmentor.core.data.model.auth

import com.djvmil.entretienmentor.core.data.source.api.model.UserApiModel
import kotlinx.serialization.Serializable

@Serializable
data class ResponseAuthData(
	val user: UserApiModel? = null,
	val accesToken: String? = null
)
