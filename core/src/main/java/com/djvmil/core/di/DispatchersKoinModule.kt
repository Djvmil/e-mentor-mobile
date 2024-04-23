package com.djvmil.core.di

import android.content.Context
import android.util.Log
import com.djvmil.core.KEYSET_NAME
import com.djvmil.core.MASTER_KEY_URI
import com.djvmil.core.PREFERENCE_FILE
import com.djvmil.core.crypto.CryptoImpl
import com.djvmil.core.dispatcher.AppDispatchers
import com.djvmil.core.dispatcher.IAppDispatchers
import com.djvmil.core.network.ConnectivityManagerNetworkMonitor
import com.djvmil.core.network.NetworkMonitor
import com.google.crypto.tink.Aead
import com.google.crypto.tink.aead.AeadConfig
import com.google.crypto.tink.aead.AesGcmKeyManager
import com.google.crypto.tink.integration.android.AndroidKeysetManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dispatchersKoinModule = module {
    singleOf(::ConnectivityManagerNetworkMonitor) { bind<NetworkMonitor>() }
    singleOf(::AppDispatchers){ bind<IAppDispatchers>() }

    single<CoroutineScope>( named("AppCoroutineScope") ) {
        CoroutineScope(get<AppDispatchers>().io + SupervisorJob())
    }

    singleOf(::CryptoImpl)
    single { provideAead(get()) }

}

private fun provideAead(context: Context): Aead {
    try {
        AeadConfig.register()

        return AndroidKeysetManager.Builder()
            .withSharedPref(context, KEYSET_NAME, PREFERENCE_FILE)
            .withKeyTemplate(AesGcmKeyManager.aes256GcmTemplate())
            .withMasterKeyUri(MASTER_KEY_URI)
            .build()
            .keysetHandle
            .getPrimitive(Aead::class.java)
    } catch (e: Exception) {
        // Gérer l'exception ici, par exemple, en affichant un message d'erreur ou en journalisant l'erreur.
        Log.d("YourTag", "Erreur lors de la fourniture d'Aead", e)
        // Si nécessaire, lancer une nouvelle exception ou retourner une valeur par défaut.
        throw RuntimeException("Impossible de fournir Aead", e)
    }

}
