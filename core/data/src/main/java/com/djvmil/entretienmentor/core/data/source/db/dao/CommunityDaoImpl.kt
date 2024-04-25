package com.djvmil.data.source.db.dao

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import app.cash.sqldelight.coroutines.mapToOne
import com.djvmil.DatabaseSource
import com.djvmil.data.source.db.util.THROW_QUERY_INSERT_MOVIE_EXCEPTION
import com.djvmil.sqldelight.CommunityTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class CommunityDaoImpl(
    db: DatabaseSource
) : CommunityDao {

    private val query = db.community_tableQueries
    override fun getAll(): Flow<List<CommunityTable>> =
        query.getAll()
            .asFlow()
            .mapToList(Dispatchers.IO)


    override fun getById(id: Int): Flow<CommunityTable> =
        query.getById(id.toLong())
            .asFlow()
            .mapToOne(Dispatchers.IO)



    override suspend fun update(community: CommunityTable) {
        query.update(
            id = community.id,
            name = community.name,
            description = community.description,
            dateCreated = community.dateCreated,
            dateUpdated = community.dateUpdated
        )
    }

    override suspend fun insertAll(communities: List<CommunityTable>) {
        query.transaction {
            afterRollback { throw Exception(THROW_QUERY_INSERT_MOVIE_EXCEPTION) }

            communities.forEach { community ->
                query.insert(
                    id = community.id,
                    name = community.name,
                    description = community.description,
                    dateCreated = community.dateCreated,
                    dateUpdated = community.dateUpdated
                )
            }
        }
    }

    override suspend fun deleteAll() {
        query.deleteAll()
    }
}