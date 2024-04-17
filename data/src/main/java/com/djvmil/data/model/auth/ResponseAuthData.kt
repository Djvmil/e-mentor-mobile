package com.djvmil.data.model.auth

import com.squareup.moshi.Json

data class ResponseAuthData(
	@field:Json(name="user")
	val user: User? = null,

	@field:Json(name="accesToken")
	val accesToken: String? = null
)

data class RolesItem(
	@field:Json(name="role")
	val role: String? = null,

	@field:Json(name="dateCreated")
	val dateCreated: String? = null,

	@field:Json(name="roleID")
	val roleID: Int? = null,

	@field:Json(name="dateUpdated")
	val dateUpdated: String? = null
)

data class User(
	@field:Json(name="country")
	val country: String? = null,

	@field:Json(name="firstname")
	val firstname: String? = null,

	@field:Json(name="roles")
	val roles: List<RolesItem?>? = null,

	@field:Json(name="userID")
	val userID: Int? = null,

	@field:Json(name="birthDate")
	val birthDate: String? = null,

	@field:Json(name="isEmailVerified")
	val isEmailVerified: String? = null,

	@field:Json(name="lastname")
	val lastname: String? = null,

	@field:Json(name="dateUpdated")
	val dateUpdated: String? = null,

	@field:Json(name="isPhoneNumbeVerified")
	val isPhoneNumbeVerified: String? = null,

	@field:Json(name="phoneNumber")
	val phoneNumber: String? = null,

	@field:Json(name="dateCreated")
	val dateCreated: String? = null,

	@field:Json(name="genre")
	val genre: String? = null,

	@field:Json(name="email")
	val email: String? = null,

	@field:Json(name="username")
	val username: String? = null
)
