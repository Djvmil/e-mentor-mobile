package com.djvmil.core.di

import com.djvmil.core.utli.ConnectivityManagerNetworkMonitor
import com.djvmil.core.utli.NetworkMonitor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dispatchersKoinModule = module {
    //single<IAppDispatchers> { AppDispatchers() }
    //single<IAppDispatchers>(named("AppDispatchersMock")) { AppDispatchers() }

    singleOf(::ConnectivityManagerNetworkMonitor) { bind<NetworkMonitor>() }
    singleOf(::AppDispatchers){ bind<IAppDispatchers>() }

    single<CoroutineScope>( named("AppCoroutineScope") ) {
        CoroutineScope(get<AppDispatchers>().io + SupervisorJob())
    }

}