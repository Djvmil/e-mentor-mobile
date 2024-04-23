package com.djvmil.domain.usecase

import com.djvmil.data.repository.CommunityRepository
import com.djvmil.domain.model.CommunityDomainModel
import com.djvmil.domain.model.toData
import com.djvmil.domain.util.UseCase

class UpdateCommunityUseCase internal constructor(
    private val repository: CommunityRepository
) : UseCase<CommunityDomainModel, Unit> {
    override suspend fun invoke(community: CommunityDomainModel) =
        repository.update(community.toData())
}