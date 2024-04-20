package com.djvmil.domain.di

import com.djvmil.core.ErrorEM
import com.djvmil.core.ResultEM
import com.djvmil.data.model.auth.AuthRequest
import com.djvmil.data.model.auth.AuthResult
import com.djvmil.data.model.auth.ResponseAuthData
import com.djvmil.domain.model.CommentDomainModel
import com.djvmil.domain.model.MovieDomainModel
import com.djvmil.domain.usecase.GetMoviesOrFavoriteMoviesUseCase
import com.djvmil.domain.usecase.GetMovieUseCase
import com.djvmil.domain.usecase.LoginUseCase
import com.djvmil.domain.usecase.RegisterUseCase
import com.djvmil.domain.usecase.UpdateMovieUseCase
import com.djvmil.domain.util.UseCase
import kotlinx.coroutines.flow.Flow
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModule = module {
    singleOf(::LoginUseCase) { bind<UseCase<AuthRequest, Flow<ResultEM<AuthResult<ResponseAuthData>, ErrorEM>>>>() }
    singleOf(::RegisterUseCase) { bind<UseCase<AuthRequest, Flow<ResultEM<AuthResult<String>, ErrorEM>>>>() }
    singleOf(::GetMoviesOrFavoriteMoviesUseCase) { bind<UseCase<Boolean, Flow<ResultEM<List<MovieDomainModel>, ErrorEM>>> >() }
    singleOf(::GetMovieUseCase) { bind<UseCase<Int, Flow<ResultEM<MovieDomainModel, ErrorEM>>>>() }
    singleOf(::UpdateMovieUseCase) { bind<UseCase<MovieDomainModel, Unit>>() }
}