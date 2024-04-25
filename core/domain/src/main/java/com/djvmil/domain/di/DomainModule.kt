package com.djvmil.domain.di

import com.djvmil.common.model.ErrorEM
import com.djvmil.common.model.ResultEM
import com.djvmil.data.model.auth.AuthRequest
import com.djvmil.data.model.auth.RequestResult
import com.djvmil.data.model.auth.ResponseAuthData
import com.djvmil.domain.model.CommunityDomainModel
import com.djvmil.domain.usecase.GetCommunityUseCase
import com.djvmil.domain.usecase.LoginUseCase
import com.djvmil.domain.usecase.RegisterUseCase
import com.djvmil.domain.usecase.UpdateCommunityUseCase
import com.djvmil.domain.util.UseCase
import kotlinx.coroutines.flow.Flow
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModule = module {
    singleOf(::LoginUseCase) { bind<UseCase<AuthRequest, Flow<ResultEM<RequestResult<ResponseAuthData>, ErrorEM>>>>() }
    singleOf(::RegisterUseCase) { bind<UseCase<AuthRequest, Flow<ResultEM<RequestResult<String>, ErrorEM>>>>() }
    singleOf(::GetCommunityUseCase) { bind<UseCase<Int, Flow<ResultEM<CommunityDomainModel, ErrorEM>>>>() }
    singleOf(::UpdateCommunityUseCase) { bind<UseCase<CommunityDomainModel, Unit>>() }
}