package com.djvmil.domain.usecase

import com.djvmil.common.model.ErrorEM
import com.djvmil.common.model.ResultEM
import com.djvmil.common.model.map
import com.djvmil.data.repository.CommunityRepository
import com.djvmil.domain.model.CommunityDomainModel
import com.djvmil.domain.model.toDomain
import com.djvmil.domain.util.UseCaseNoInput
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAndStoreAllCommunityUseCase internal constructor(
    private val repository: CommunityRepository
) : UseCaseNoInput<Flow<ResultEM<List<CommunityDomainModel>, ErrorEM>>> {
    override suspend fun invoke(): Flow<ResultEM<List<CommunityDomainModel>, ErrorEM>> {
        repository.getFromApi()
        return repository.getAll().map { result ->
            result.map { list ->
                list.map { it.toDomain() }
            }
        }
    }
}
