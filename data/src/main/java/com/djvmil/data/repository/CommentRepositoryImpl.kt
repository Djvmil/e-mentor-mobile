package com.djvmil.data.repository

import com.djvmil.data.model.CommentDataModel
import com.djvmil.data.model.toData
import com.djvmil.data.source.api.api.ApiServiceImpl
import com.djvmil.core.ErrorEM
import com.djvmil.core.ResultEM
import com.djvmil.core.map
import com.djvmil.data.source.db.dao.CommentDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CommentRepositoryImpl constructor(
    val api: ApiServiceImpl,
    val dao: CommentDao
) : CommentRepository {

    override fun getAll(movieId: Int): Flow<ResultEM<List<CommentDataModel>, ErrorEM>> =
        api.getComments().map { result ->
            result.map { list ->
                list.map { it.toData() }
            }
        }

    override fun insertAll(comments: List<CommentDataModel>) {
    }

    override fun insert(comment: CommentDataModel) {
    }

    override fun deleteAll() {
    }
}