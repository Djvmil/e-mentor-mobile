package com.djvmil.domain.usecase

import com.djvmil.data.repository.MovieRepository
import com.djvmil.core.ErrorEM
import com.djvmil.core.ResultEM
import com.djvmil.core.map
import com.djvmil.domain.model.MovieDomainModel
import com.djvmil.domain.model.toDomain
import com.djvmil.domain.util.UseCaseNoInput
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAndStoreAllMovieUseCase internal constructor(
    private val repository: MovieRepository
) : UseCaseNoInput<Flow<ResultEM<List<MovieDomainModel>, ErrorEM>>> {
    override suspend fun invoke(): Flow<ResultEM<List<MovieDomainModel>, ErrorEM>> {
        repository.getFromApi()
        return repository.getAll().map { result ->
            result.map { list ->
                list.map { it.toDomain() }
            }
        }
    }
}
