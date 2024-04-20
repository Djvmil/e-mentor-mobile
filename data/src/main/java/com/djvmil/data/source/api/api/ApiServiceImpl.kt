package com.djvmil.data.source.api.api

import com.djvmil.core.ErrorEM
import com.djvmil.core.ResultEM
import com.djvmil.data.model.ApiOperation
import com.djvmil.data.model.auth.AuthRequest
import com.djvmil.data.model.auth.AuthResult
import com.djvmil.data.model.auth.ResponseAuthData
import com.djvmil.data.repository.safeApiCall
import com.djvmil.data.source.api.model.CommentApiModel
import com.djvmil.data.source.api.model.MovieApiModel
import com.djvmil.data.source.api.util.Route.COMMENTS_URL
import com.djvmil.data.source.api.util.Route.LOGIN_URL
import com.djvmil.data.source.api.util.Route.MOVIES_URL
import com.djvmil.data.source.api.util.Route.REGISTER_URL
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ApiServiceImpl(val httpClient: HttpClient) : ApiService {
    override suspend fun login(body: AuthRequest): ApiOperation<AuthResult<ResponseAuthData>> {
        return httpClient.post {
            url(LOGIN_URL)
            setBody (body)
        }.body()
    }

    override suspend fun register(body: AuthRequest): ApiOperation<AuthResult<String>> {
        return httpClient.post {
            url(REGISTER_URL)
            setBody (body)
        }.body()
    }

    override fun getMovies(): Flow<ResultEM<List<MovieApiModel>, ErrorEM>> = flow {
        emit(ResultEM.Loading)
        try {
            emit(
                ResultEM.Success(
                    httpClient.get(MOVIES_URL).body()
                )
            )
        } catch (exception: Exception) {
            exception.printStackTrace()
            emit(
                ResultEM.Failure(ErrorEM(message = exception.message ?: "", throwable = exception))
            )
        }
    }

    override fun getComments(): Flow<ResultEM<List<CommentApiModel>, ErrorEM>> = flow {
        emit(ResultEM.Loading)
        try {
            emit(
                ResultEM.Success(
                    httpClient.get(COMMENTS_URL).body()
                )
            )
        } catch (exception: Exception) {
            emit(
                ResultEM.Failure(ErrorEM(message = exception.message ?: "", throwable = exception))
            )
        }
    }
}