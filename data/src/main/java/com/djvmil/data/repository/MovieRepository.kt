package com.djvmil.data.repository

import com.djvmil.data.model.MovieDataModel
import com.djvmil.core.ErrorEM
import com.djvmil.core.ResultEM
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getFromApi()
    fun getAll(): Flow<ResultEM<List<MovieDataModel>, ErrorEM>>
    fun get(id: Int): Flow<ResultEM<MovieDataModel, ErrorEM>>
    fun getAllLiked(): Flow<ResultEM<List<MovieDataModel>, ErrorEM>>

    suspend fun update(movie: MovieDataModel)
    suspend fun insertAll(movies: List<MovieDataModel>)
    suspend fun deleteAll()
}