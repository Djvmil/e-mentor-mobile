package com.djvmil.data.repository

import com.djvmil.data.model.CommentDataModel
import com.djvmil.core.ErrorEM
import com.djvmil.core.ResultEM
import kotlinx.coroutines.flow.Flow

interface CommentRepository {
    fun getAll(movieId: Int): Flow<ResultEM<List<CommentDataModel>, ErrorEM>>
    fun insertAll(comments: List<CommentDataModel>)
    fun insert(comment: CommentDataModel)
    fun deleteAll()
}