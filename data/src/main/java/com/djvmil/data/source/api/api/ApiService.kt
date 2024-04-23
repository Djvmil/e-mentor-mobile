package com.djvmil.data.source.api.api

import com.djvmil.core.model.ErrorEM
import com.djvmil.core.model.ResultEM
import com.djvmil.data.model.ApiOperation
import com.djvmil.data.model.auth.AuthRequest
import com.djvmil.data.model.auth.RequestResult
import com.djvmil.data.model.auth.ResponseAuthData
import com.djvmil.data.source.api.model.CommunityApiModel
import kotlinx.coroutines.flow.Flow

interface ApiService {
    suspend fun login(body: AuthRequest): ApiOperation<RequestResult<ResponseAuthData>>
    suspend fun register(body: AuthRequest): ApiOperation<RequestResult<String>>

    fun getCommunities(): Flow<ResultEM<List<CommunityApiModel>, ErrorEM>>
   // fun getComments(): Flow<ResultEM<List<CommentApiModel>, ErrorEM>>
}