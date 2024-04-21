package com.djvmil.data.repository

import com.djvmil.data.model.MovieDataModel
import com.djvmil.data.model.toData
import com.djvmil.data.model.toDatabase
import com.djvmil.data.source.api.api.ApiService
import com.djvmil.core.ErrorEM
import com.djvmil.core.ResultEM
import com.djvmil.data.source.datastore.AppSettingsDataStoreSource
import com.djvmil.data.source.datastore.IAppSettingsDataStoreSource
import com.djvmil.data.source.db.dao.MovieDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class MovieRepositoryImpl(
    val api: ApiService,
    val dao: MovieDao,
    val dataStore: IAppSettingsDataStoreSource
) : MovieRepository {
    override suspend fun getFromApi() {
        api.getMovies().collect { result ->
            if (result is ResultEM.Success)
                dao.insertAll(result.value.map { it.toData().toDatabase() })
        }
    }

    override fun getAll(): Flow<ResultEM<List<MovieDataModel>, ErrorEM>> {
        return dao.getAll().map { list ->
            list.map { it.toData() }
        }
            .map { ResultEM.Success(value = it) }
            .catch { throwable ->
                ResultEM.Failure(ErrorEM(throwable = throwable))
            }
    }

    override fun get(id: Int): Flow<ResultEM<MovieDataModel, ErrorEM>> =
        dao.getMovie(id)
            .map { it.toData() }
            .map { ResultEM.Success(value = it) }
            .catch { throwable ->
                ResultEM.Failure(ErrorEM(throwable = throwable))
            }

    override fun getAllLiked(): Flow<ResultEM<List<MovieDataModel>, ErrorEM>> =
        dao.getAllLiked()
            .map { list ->
                list.map { it.toData() }
            }.map { ResultEM.Success(value = it) }
            .catch { throwable ->
                ResultEM.Failure(ErrorEM(throwable = throwable))
            }

    override suspend fun update(movie: MovieDataModel) {
        dao.update(movie.toDatabase())
    }

    override suspend fun insertAll(movies: List<MovieDataModel>) =
        dao.insertAll(
            movies.map { model ->
                model.toDatabase()
            }
        )

    override suspend fun deleteAll() {
        dao.deleteAll()
    }
}