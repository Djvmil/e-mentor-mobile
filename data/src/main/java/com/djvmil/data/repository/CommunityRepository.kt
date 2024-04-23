package com.djvmil.data.repository

import com.djvmil.core.model.ErrorEM
import com.djvmil.core.model.ResultEM
import com.djvmil.data.model.CommunityDataModel
import kotlinx.coroutines.flow.Flow

interface CommunityRepository {
    suspend fun getFromApi()
    fun getAll(): Flow<ResultEM<List<CommunityDataModel>, ErrorEM>>
    fun get(id: Int): Flow<ResultEM<CommunityDataModel, ErrorEM>>

    suspend fun update(communities: CommunityDataModel)
    suspend fun insertAll(communities: List<CommunityDataModel>)
    suspend fun deleteAll()
}