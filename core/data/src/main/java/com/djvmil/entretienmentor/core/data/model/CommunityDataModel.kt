package com.djvmil.data.model

import com.djvmil.data.source.api.model.CommunityApiModel
import com.djvmil.sqldelight.CommunityTable

class CommunityDataModel (
    val id: Int,
    val name: String? ,
    val description: String?,
    val dateCreated: String?,
    val dateUpdated: String?
)


internal fun CommunityApiModel.toData() = CommunityDataModel(
    id = id,
    name = name,
    description = description,
    dateCreated = dateCreated,
    dateUpdated = dateUpdated,
)

internal fun CommunityTable.toData() = CommunityDataModel(
    id = id.toInt(),
    name = name,
    description = description,
    dateCreated = dateCreated,
    dateUpdated = dateUpdated,
)

internal fun CommunityDataModel.toDatabase() = CommunityTable(
    id = id.toLong(),
    name = name ?: "null",
    description = description,
    dateCreated = dateCreated,
    dateUpdated = dateUpdated,
)