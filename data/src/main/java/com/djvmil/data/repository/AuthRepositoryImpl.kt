package com.djvmil.data.repository

import android.net.http.HttpException
import com.djvmil.core.ResultEM
import com.djvmil.data.source.api.api.ApiService
import java.io.IOException
/*
class AuthRepositoryImpl(
    private val apiService: ApiService,
    private val preferences: AuthPreferences

) : AuthRepository{
    override suspend fun login(loginRequest: AuthRequest): ResultEM<Unit> {
       return try {
           val response = apiService.loginUser(loginRequest)
           preferences.saveAuthToken(response.token)
           ResultEM.Success(Unit)
       }catch (e: IOException){
           ResultEM.Failure("${e.message}")
       }catch (e: HttpException){
           ResultEM.Failure("${e.message}")
       }
    }

    override suspend fun register(registerRequest: AuthRequest): Resource<Unit> {
        return try {
           val response = apiService.registerUser(registerRequest)
            preferences.saveAuthToken(response.token)
            Resource.Success(Unit)
        }catch (e: IOException){
            Resource.Error("${e.message}")
        }catch (e: HttpException){
            Resource.Error("${e.message}")
        }
    }


}*/