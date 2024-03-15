package com.djvmil.di

import com.djvmil.data.di.dataModule
import com.djvmil.domain.di.domainModule
import org.koin.dsl.module

object ProvideModules {

    fun getModules() = module {
        includes(
            dataModule,
            domainModule
        )
    }
}