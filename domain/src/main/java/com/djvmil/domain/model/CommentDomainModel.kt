package com.djvmil.domain.model

import com.djvmil.data.model.CommentDataModel

data class CommentDomainModel(
    val id: Int,
    val title: String
)

internal fun CommentDataModel.toDomain() = CommentDomainModel(
    id = id,
    title = title
)