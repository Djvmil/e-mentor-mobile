package com.djvmil.domain.usecase

import com.djvmil.common.model.ErrorEM
import com.djvmil.common.model.ResultEM
import com.djvmil.common.model.map
import com.djvmil.data.repository.CommunityRepository
import com.djvmil.domain.model.CommunityDomainModel
import com.djvmil.domain.model.toDomain
import com.djvmil.domain.util.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCommunityUseCase internal constructor(
    private val repository: CommunityRepository
) : UseCase<Int, Flow<ResultEM<CommunityDomainModel, ErrorEM>>> {
    override suspend fun invoke(input: Int): Flow<ResultEM<CommunityDomainModel, ErrorEM>> =
        repository.get(input).map {
            it.map { it.toDomain() }
        }
}