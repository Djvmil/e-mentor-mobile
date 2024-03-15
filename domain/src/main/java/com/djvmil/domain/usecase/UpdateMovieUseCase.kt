package com.djvmil.domain.usecase

import com.djvmil.data.repository.MovieRepository
import com.djvmil.domain.model.MovieDomainModel
import com.djvmil.domain.model.toData
import com.djvmil.domain.util.UseCase

class UpdateMovieUseCase internal constructor(
    private val repository: MovieRepository
) : UseCase<MovieDomainModel, Unit> {
    override suspend fun invoke(movie: MovieDomainModel) =
        repository.update(movie.toData())
}