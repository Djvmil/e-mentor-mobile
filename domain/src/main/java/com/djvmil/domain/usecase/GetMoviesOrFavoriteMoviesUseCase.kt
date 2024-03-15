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

class GetMoviesOrFavoriteMoviesUseCase internal constructor(
    private val repository: MovieRepository
) : UseCase<Boolean, Flow<ResultEM<List<MovieDomainModel>, ErrorEM>>> {
    override suspend fun invoke(isFavorite: Boolean): Flow<ResultEM<List<MovieDomainModel>, ErrorEM>> {
        return if (isFavorite) repository.getAllLiked().map { result ->
            result.map { list ->
                list.map { it.toDomain() }
            }
        } else repository.getAll().map { result ->
            result.map { list ->
                list.map { it.toDomain() }
            }
        }
    }
}
