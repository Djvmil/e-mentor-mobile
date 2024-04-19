package com.djvmil.data.model.auth

import kotlinx.serialization.Serializable

@Serializable
data class ResponseAuthData(
	val user: User? = null,
	val accesToken: String? = null
)

@Serializable
data class RolesItem(
	val role: String? = null,
	val dateCreated: String? = null,
	val roleID: Int? = null,
	val dateUpdated: String? = null
)

@Serializable
data class User(
	val country: String? = null,
	val firstname: String? = null,
	val roles: List<RolesItem?>? = null,
	val userID: Int? = null,
	val birthDate: String? = null,
	val isEmailVerified: String? = null,
	val lastname: String? = null,
	val dateUpdated: String? = null,
	val isPhoneNumbeVerified: String? = null,
	val phoneNumber: String? = null,
	val dateCreated: String? = null,
	val genre: String? = null,
	val email: String? = null,
	val username: String? = null
)
