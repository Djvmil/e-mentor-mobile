package com.djvmil.data.repository

import android.util.Log
import com.djvmil.core.ErrorEM
import com.djvmil.core.ResultEM
import com.djvmil.data.model.ApiOperation
import com.djvmil.data.model.auth.AuthRequest
import com.djvmil.data.model.auth.AuthResult
import com.djvmil.data.model.auth.ResponseAuthData
import com.djvmil.data.model.mapSuccess
import com.djvmil.data.model.onFailure
import com.djvmil.data.model.onSuccess
import com.djvmil.data.source.api.api.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthRepositoryImpl(
    private val apiService: ApiService
) : AuthRepository{

    override suspend fun login(loginRequest: AuthRequest): Flow<ResultEM<AuthResult<ResponseAuthData>, ErrorEM>> = flow{
        safeApiCall {
            emit(ResultEM.Loading)
            Log.e("AuthRepositoryImpl", "login Loading")
            apiService.login(loginRequest)

        }.onSuccess { response ->
            Log.e("AuthRepositoryImpl", "login onSuccess: $response")

            response.mapSuccess { result ->
                emit(ResultEM.Success(result) )
            }

        }.onFailure { error ->
            Log.e("AuthRepositoryImpl ", "login onFailure: $error")
            emit(ResultEM.Failure(ErrorEM(throwable = error)))

        }

    }

    override suspend fun register(registerRequest: AuthRequest): Flow<ResultEM<AuthResult<String>, ErrorEM>> = flow {
        safeApiCall {
            Log.e("AuthRepositoryImpl", "register Loading")
            emit(ResultEM.Loading)
            apiService.register(registerRequest)
        }.onSuccess { response ->
            Log.e("AuthRepositoryImpl", "register onSuccess: $response")
            response.mapSuccess { result ->
                emit(ResultEM.Success(result) )
            }

        }.onFailure { error ->
            Log.e("AuthRepositoryImpl ", "register onFailure: $error")
            emit(ResultEM.Failure(ErrorEM(throwable = error)))

        }

    }


}

inline fun <T> safeApiCall(apiCall: () -> T): ApiOperation<T> {
    return try {
        ApiOperation.Success(data = apiCall())
    } catch (e: Exception) {
        ApiOperation.Failure(exception = e)
    }
}