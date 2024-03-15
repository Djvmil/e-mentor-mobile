package com.djvmil.domain.usecase

import com.djvmil.data.repository.MovieRepository
import com.djvmil.core.ErrorEM
import com.djvmil.core.ResultEM
import com.djvmil.core.map
import com.djvmil.domain.model.MovieDomainModel
import com.djvmil.domain.model.toDomain
import com.djvmil.domain.util.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetMovieUseCase internal constructor(
    private val repository: MovieRepository
) : UseCase<Int, Flow<ResultEM<MovieDomainModel, ErrorEM>>> {
    override suspend fun invoke(input: Int): Flow<ResultEM<MovieDomainModel, ErrorEM>> =
        repository.get(input).map {
            it.map { it.toDomain() }
        }
}