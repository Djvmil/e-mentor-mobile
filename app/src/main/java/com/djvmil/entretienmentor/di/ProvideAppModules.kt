package com.djvmil.entretienmentor.di

import com.djvmil.data.di.dataModule
import com.djvmil.domain.di.domainModule
import com.djvmil.entretienmentor.presentation.di.featureModule
import org.koin.dsl.module

object ProvideAppModules {

    fun getAppModules() = module {
        includes(
            dataModule,
            domainModule,
            featureModule
        )
    }
}