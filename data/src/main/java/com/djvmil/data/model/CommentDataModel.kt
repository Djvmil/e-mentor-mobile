package com.djvmil.data.model

import com.djvmil.data.source.api.model.CommentApiModel
import com.djvmil.sqldelight.CommentTable

data class CommentDataModel(
    val id: Int,
    val title: String,
    val movieId: Int
)

internal fun CommentApiModel.toData() = CommentDataModel(
    id = id,
    title = title,
    movieId = movieId
)

internal fun CommentTable.toData() = CommentDataModel(
    id = id.toInt(),
    title = title,
    movieId = movieId.toInt()
)