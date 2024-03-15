package com.djvmil.data.source.api.api

import com.djvmil.data.source.api.model.CommentApiModel
import com.djvmil.core.ErrorEM
import com.djvmil.data.source.api.model.MovieApiModel
import com.djvmil.core.ResultEM
import com.djvmil.data.source.api.util.Rout.COMMENTS_URL
import com.djvmil.data.source.api.util.Rout.MOVIES_URL
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ApiServiceImpl(val httpClient: HttpClient) : ApiService {
    override fun login(): Flow<ResultEM<List<MovieApiModel>, ErrorEM>> {
        TODO("Not yet implemented")
    }

    override fun register(): Flow<ResultEM<List<MovieApiModel>, ErrorEM>> {
        TODO("Not yet implemented")
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