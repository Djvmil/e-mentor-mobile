package com.djvmil.data.repository

import com.djvmil.core.ErrorEM
import com.djvmil.core.ResultEM
import com.djvmil.data.model.auth.AuthRequest
import com.djvmil.data.model.auth.AuthResult
import com.djvmil.data.model.auth.ResponseAuthData
import com.djvmil.data.source.api.api.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthRepositoryImpl(
    private val apiService: ApiService
) : AuthRepository{

    override suspend fun login(loginRequest: AuthRequest): Flow<ResultEM<AuthResult<ResponseAuthData>, ErrorEM>> = flow{
        emit(ResultEM.Loading)

        apiService.login(loginRequest).collect { result ->
            if (result is ResultEM.Success){
                //dao.insertAll(result.value.map { it.toData().toDatabase() })
                emit(ResultEM.Success(result.value))

            }else if(result is ResultEM.Failure){
                ResultEM.Failure(result.error)
            }

        }

        /*.runCatching {
            emit(ResultEM.Failure(ErrorEM(throwable = Exception(""))))
        }

        .map { list ->
        list.map { it.toData()
        }
    }.map { ResultEM.Success(value = it) }
        .catch { throwable ->
            ResultEM.Failure(ErrorEM(throwable = throwable))
        }*/
    }

    override suspend fun register(registerRequest: AuthRequest): Flow<ResultEM<AuthResult<ResponseAuthData>, ErrorEM>> = flow {
        emit(ResultEM.Loading)

        apiService.login(registerRequest).collect { result ->
            if (result is ResultEM.Success){
                //dao.insertAll(result.value.map { it.toData().toDatabase() })
                emit(ResultEM.Success(result.value))

            }else if(result is ResultEM.Failure){
                ResultEM.Failure(result.error)
            }

        }
    }

}