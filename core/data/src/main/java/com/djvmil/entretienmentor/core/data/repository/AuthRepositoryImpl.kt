package com.djvmil.entretienmentor.core.data.repository

import android.util.Log
import com.djvmil.entretienmentor.core.data.model.auth.AuthRequest
import com.djvmil.entretienmentor.core.data.model.auth.RequestExceptionResult
import com.djvmil.entretienmentor.core.data.model.auth.RequestResult
import com.djvmil.entretienmentor.core.data.model.auth.ResponseAuthData
import com.djvmil.entretienmentor.core.data.model.onFailure
import com.djvmil.entretienmentor.core.data.model.onSuccess
import com.djvmil.entretienmentor.core.data.source.api.api.ApiService
import com.djvmil.entretienmentor.core.data.source.datastore.AppSettingsDataStoreSource
import com.djvmil.entretienmentor.core.common.model.ErrorEM
import com.djvmil.entretienmentor.core.common.model.ResultEM
import com.djvmil.entretienmentor.core.data.source.datastore.model.StepsStarting
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthRepositoryImpl(
    private val apiService: ApiService,
    private val dataStoreSource: AppSettingsDataStoreSource,
) : AuthRepository {

    override suspend fun login(loginRequest: AuthRequest): Flow<ResultEM<RequestResult<ResponseAuthData>, ErrorEM>> = flow{

        emit(ResultEM.Loading)
        Log.e("AuthRepositoryImpl", "login Loading")

        apiService
            .login(loginRequest)
            .onSuccess { response ->
                Log.e("AuthRepositoryImpl", "response: appSettings ${response.data}" )

                //Save token on the data store
                response.data?.accesToken?.let {token ->
                    Log.e("AuthRepositoryImpl", "token: appSettings ${response.data}" )
                    dataStoreSource.setLogin(status = true, accessToken = token, steps = StepsStarting.ON_HOME_USER)
                }

                //Send success response
                emit(ResultEM.Success(response) )
                Log.e("AuthRepositoryImpl", "login onSuccess: $response")

            }.onFailure { error ->
                Log.e("AuthRepositoryImpl ", "login onFailure START 0 ${error.message} \n")
                emit(ResultEM.Failure(ErrorEM(throwable = error)))

            }

        apiService.getCommunities().collect{

            if (it is ResultEM.Failure){

                Log.e("AuthRepositoryImpl ", "getCommunities onFailure START 1 ${it.error.code}")

                val result = it.error.throwable as? RequestExceptionResult
                if (result != null){
                    Log.e("AuthRepositoryImpl ", "getCommunities onFailure START 2 ${result.error?.code}")
                    Log.e("AuthRepositoryImpl ", "getCommunities onFailure START 3 ${result.error?.message}")
                    Log.e("AuthRepositoryImpl ", "getCommunities onFailure START 4 ${result.error?.data}")

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
