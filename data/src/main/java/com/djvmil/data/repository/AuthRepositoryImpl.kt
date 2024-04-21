package com.djvmil.data.repository

import android.util.Log
import com.djvmil.core.ErrorEM
import com.djvmil.core.ResultEM
import com.djvmil.data.model.auth.AuthRequest
import com.djvmil.data.model.auth.RequestExceptionResult
import com.djvmil.data.model.auth.RequestResult
import com.djvmil.data.model.auth.ResponseAuthData
import com.djvmil.data.model.onFailure
import com.djvmil.data.model.onSuccess
import com.djvmil.data.source.api.api.ApiService
import com.djvmil.data.source.datastore.IAppSettingsDataStoreSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthRepositoryImpl(
    private val apiService: ApiService,
    private val dataStoreSource: IAppSettingsDataStoreSource,
) : AuthRepository{

    override suspend fun login(loginRequest: AuthRequest): Flow<ResultEM<RequestResult<ResponseAuthData>, ErrorEM>> = flow{

        emit(ResultEM.Loading)
        Log.e("AuthRepositoryImpl", "login Loading")

        apiService.login(loginRequest)
            .onSuccess { response ->


                dataStoreSource.setAccessToken(response.data?.accesToken!!)
                emit(ResultEM.Success(response) )
                Log.e("AuthRepositoryImpl", "login onSuccess: $response")

            }.onFailure { error ->
                Log.e("AuthRepositoryImpl ", "login onFailure START 0 ${error.message} \n")
                emit(ResultEM.Failure(ErrorEM(throwable = error)))

            }

        apiService.getMovies().collect{

            if (it is ResultEM.Failure){

                Log.e("AuthRepositoryImpl ", "getMovies onFailure START 1 ${it.error.code}")

                val result = it.error.throwable as? RequestExceptionResult
                if (result != null){
                    Log.e("AuthRepositoryImpl ", "getMovies onFailure START 2 ${result.error?.code}")
                    Log.e("AuthRepositoryImpl ", "getMovies onFailure START 3 ${result.error?.message}")
                    Log.e("AuthRepositoryImpl ", "getMovies onFailure START 4 ${result.error?.data}")

                }
            }
        }

    }

    override suspend fun register(registerRequest: AuthRequest): Flow<ResultEM<RequestResult<String>, ErrorEM>> = flow {

        emit(ResultEM.Loading)
        Log.e("AuthRepositoryImpl", "register Loading")
        apiService.register(registerRequest)
            .onSuccess { response ->
                Log.e("AuthRepositoryImpl", "register onSuccess: $response")
                emit(ResultEM.Success(response) )

            }.onFailure { error ->
                Log.e("AuthRepositoryImpl ", "register onFailure: $error")
                emit(ResultEM.Failure(ErrorEM(throwable = error)))

            }

    }


}
