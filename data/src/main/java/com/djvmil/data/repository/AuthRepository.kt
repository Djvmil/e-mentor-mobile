package com.djvmil.data.repository

import com.djvmil.core.ErrorEM
import com.djvmil.core.ResultEM
import com.djvmil.data.model.auth.AuthRequest
import com.djvmil.data.model.auth.AuthResult
import com.djvmil.data.model.auth.ResponseAuthData
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(loginRequest: AuthRequest): Flow<ResultEM<AuthResult<ResponseAuthData>, ErrorEM>>
    suspend fun register(registerRequest: AuthRequest): Flow<ResultEM<AuthResult<ResponseAuthData>, ErrorEM>>
}