package com.djvmil.data.source.api.api

import com.djvmil.data.source.api.model.CommentApiModel
import com.djvmil.core.ErrorEM
import com.djvmil.data.source.api.model.MovieApiModel
import com.djvmil.core.ResultEM
import kotlinx.coroutines.flow.Flow

interface ApiService {
    fun login(): Flow<ResultEM<List<MovieApiModel>, ErrorEM>>
    fun register(): Flow<ResultEM<List<MovieApiModel>, ErrorEM>>
    fun getMovies(): Flow<ResultEM<List<MovieApiModel>, ErrorEM>>
    fun getComments(): Flow<ResultEM<List<CommentApiModel>, ErrorEM>>
}