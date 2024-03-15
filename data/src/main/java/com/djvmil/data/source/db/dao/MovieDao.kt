package com.djvmil.data.source.db.dao

import com.djvmil.sqldelight.MovieTable
import kotlinx.coroutines.flow.Flow

interface MovieDao {
    fun getAll(): Flow<List<MovieTable>>

    fun getMovie(movieId: Int): Flow<MovieTable>

    fun getAllLiked(): Flow<List<MovieTable>>

    suspend fun update(movie: MovieTable)

    suspend fun insertAll(movies: List<MovieTable>)

    suspend fun deleteAll()
}