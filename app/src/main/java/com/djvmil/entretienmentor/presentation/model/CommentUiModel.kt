package com.djvmil.entretienmentor.presentation.model

import com.djvmil.domain.model.CommentDomainModel

data class CommentUiModel(
    val id: Int,
    val title: String
)

internal fun CommentDomainModel.toUi() = CommentUiModel(
    id = id,
    title = title
)