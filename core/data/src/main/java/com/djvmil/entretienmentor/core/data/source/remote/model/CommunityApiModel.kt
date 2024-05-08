package com.djvmil.entretienmentor.core.data.source.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class CommunityApiModel(
    val id: Int,
    val name: String,
    val description: String,
    val dateCreated: String,
    val dateUpdated: String,
)