package com.djvmil.domain.usecase

import com.djvmil.data.repository.MovieRepository
import com.djvmil.core.ErrorEM
import com.djvmil.core.ResultEM
import com.djvmil.core.map
import com.djvmil.data.model.auth.AuthRequest
import com.djvmil.data.model.auth.AuthResult
import com.djvmil.data.model.auth.ResponseAuthData
import com.djvmil.data.repository.AuthRepository
import com.djvmil.domain.model.MovieDomainModel
import com.djvmil.domain.model.toDomain
import com.djvmil.domain.util.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LoginUseCase internal constructor(
    private val repository: AuthRepository
) : UseCase<AuthRequest, Flow<ResultEM<AuthResult<ResponseAuthData>, ErrorEM>>> {
    override suspend fun invoke(input: AuthRequest): Flow<ResultEM<AuthResult<ResponseAuthData>, ErrorEM>> =
        repository.login(input)/*.map {
            it.map { it.toDomain() }
        }*/
}