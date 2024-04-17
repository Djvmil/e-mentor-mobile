package com.djvmil.data.source.api.api

import com.djvmil.data.source.api.model.CommentApiModel
import com.djvmil.core.ErrorEM
import com.djvmil.data.source.api.model.MovieApiModel
import com.djvmil.core.ResultEM
import com.djvmil.data.model.auth.AuthRequest
import com.djvmil.data.model.auth.AuthResult
import com.djvmil.data.model.auth.ResponseAuthData
import kotlinx.coroutines.flow.Flow

interface ApiService {
    //fun login(body: AuthRequest): Flow<AuthResult<ResponseAuthData>>
    //fun register(body: AuthRequest): Flow<AuthResult<Unit>>
    fun login(body: AuthRequest): Flow<ResultEM<AuthResult<ResponseAuthData>, ErrorEM>>
    fun register(body: AuthRequest): Flow<ResultEM<AuthResult<Unit>, ErrorEM>>
    fun getMovies(): Flow<ResultEM<List<MovieApiModel>, ErrorEM>>
    fun getComments(): Flow<ResultEM<List<CommentApiModel>, ErrorEM>>
}