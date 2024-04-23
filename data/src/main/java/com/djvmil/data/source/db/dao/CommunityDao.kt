package com.djvmil.data.source.db.dao

import com.djvmil.sqldelight.CommunityTable
import kotlinx.coroutines.flow.Flow

interface CommunityDao {
    fun getAll(): Flow<List<CommunityTable>>

    fun getById(id: Int): Flow<CommunityTable>

    suspend fun update(community: CommunityTable)

    suspend fun insertAll(communities: List<CommunityTable>)

    suspend fun deleteAll()
}