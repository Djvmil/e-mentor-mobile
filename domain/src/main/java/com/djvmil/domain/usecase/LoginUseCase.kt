package com.djvmil.domain.usecase

import com.djvmil.core.ErrorEM
import com.djvmil.core.ResultEM
import com.djvmil.data.model.auth.AuthRequest
import com.djvmil.data.model.auth.RequestResult
import com.djvmil.data.model.auth.ResponseAuthData
import com.djvmil.data.repository.AuthRepository
import com.djvmil.domain.util.UseCase
import kotlinx.coroutines.flow.Flow

class LoginUseCase internal constructor(
    private val repository: AuthRepository
) : UseCase<AuthRequest, Flow<ResultEM<RequestResult<ResponseAuthData>, ErrorEM>>> {
    override suspend fun invoke(input: AuthRequest): Flow<ResultEM<RequestResult<ResponseAuthData>, ErrorEM>> =
        repository.login(input)/*.map {
            it.map { it.toDomain() }
        }*/
}