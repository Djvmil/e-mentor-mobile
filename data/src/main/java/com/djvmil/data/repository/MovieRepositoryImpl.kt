package com.djvmil.data.repository

import com.djvmil.core.model.ErrorEM
import com.djvmil.core.model.ResultEM
import com.djvmil.data.model.CommunityDataModel
import com.djvmil.data.model.toData
import com.djvmil.data.model.toDatabase
import com.djvmil.data.source.api.api.ApiService
import com.djvmil.data.source.datastore.AppSettingsDataStoreSource
import com.djvmil.data.source.db.dao.CommunityDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class MovieRepositoryImpl(
    val api: ApiService,
    val dao: CommunityDao,
    val dataStore: AppSettingsDataStoreSource
) : CommunityRepository {
    override suspend fun getFromApi() {
        api.getCommunities().collect { result ->
            if (result is ResultEM.Success)
                dao.insertAll(result.value.map { it.toData().toDatabase() })
        }
    }

    override fun getAll(): Flow<ResultEM<List<CommunityDataModel>, ErrorEM>> {
        return dao.getAll().map { list ->
            list.map { it.toData() }
        }
            .map { ResultEM.Success(value = it) }
            .catch { throwable ->
                ResultEM.Failure(ErrorEM(throwable = throwable))
            }
    }

    override fun get(id: Int): Flow<ResultEM<CommunityDataModel, ErrorEM>> =
        dao.getById(id)
            .map { it.toData() }
            .map { ResultEM.Success(value = it) }
            .catch { throwable ->
                ResultEM.Failure(ErrorEM(throwable = throwable))
            }


    override suspend fun update(community: CommunityDataModel) {
        dao.update(community.toDatabase())
    }

    override suspend fun insertAll(communities: List<CommunityDataModel>) =
        dao.insertAll(
            communities.map { model ->
                model.toDatabase()
            }
        )

    override suspend fun deleteAll() {
        dao.deleteAll()
    }
}