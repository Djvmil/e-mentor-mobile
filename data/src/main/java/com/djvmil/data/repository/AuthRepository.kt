package com.djvmil.data.repository

import com.djvmil.core.model.ErrorEM
import com.djvmil.core.model.ResultEM
import com.djvmil.data.model.auth.AuthRequest
import com.djvmil.data.model.auth.RequestResult
import com.djvmil.data.model.auth.ResponseAuthData
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(loginRequest: AuthRequest): Flow<ResultEM<RequestResult<ResponseAuthData>, ErrorEM>>
    suspend fun register(registerRequest: AuthRequest): Flow<ResultEM<RequestResult<String>, ErrorEM>>
}