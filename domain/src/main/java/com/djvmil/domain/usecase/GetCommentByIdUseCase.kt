package com.djvmil.domain.usecase

import com.djvmil.data.repository.CommentRepository
import com.djvmil.core.ErrorEM
import com.djvmil.core.ResultEM
import com.djvmil.core.map
import com.djvmil.domain.model.CommentDomainModel
import com.djvmil.domain.model.toDomain
import com.djvmil.domain.util.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCommentByIdUseCase internal constructor(
    private val repository: CommentRepository
) : UseCase<Int, Flow<ResultEM<List<CommentDomainModel>, ErrorEM>>> {
    override suspend fun invoke(movieId: Int): Flow<ResultEM<List<CommentDomainModel>, ErrorEM>> =
        repository.getAll(movieId).map { result ->
            result.map { list ->
                list.filter { it.movieId == movieId }
                    .map { it.toDomain() }
            }
        }
}