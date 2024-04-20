package com.djvmil.data.di

import android.content.Context
import androidx.datastore.core.DataStoreFactory
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.djvmil.DatabaseSource
import com.djvmil.core.di.dispatchersKoinModule
import com.djvmil.data.repository.AuthRepository
import com.djvmil.data.repository.AuthRepositoryImpl
import com.djvmil.data.repository.MovieRepository
import com.djvmil.data.repository.MovieRepositoryImpl
import com.djvmil.data.source.api.api.ApiService
import com.djvmil.data.source.api.api.ApiServiceImpl
import com.djvmil.data.source.api.util.CustomHttpLogger
import com.djvmil.data.source.api.util.Route
import com.djvmil.data.source.datastore.AppSettingsDataStoreSource
import com.djvmil.data.source.datastore.AppSettingsDataStoreSource.Companion.DATASTORE_FILE
import com.djvmil.data.source.datastore.AppSettingsDataStoreSource.Companion.KEYSET_NAME
import com.djvmil.data.source.datastore.AppSettingsDataStoreSource.Companion.MASTER_KEY_URI
import com.djvmil.data.source.datastore.AppSettingsDataStoreSource.Companion.PREFERENCE_FILE
import com.djvmil.data.source.datastore.AppSettingsSerializer
import com.djvmil.data.source.datastore.IAppSettingsDataStoreSource
import com.djvmil.data.source.db.dao.CommentDao
import com.djvmil.data.source.db.dao.CommentDaoImpl
import com.djvmil.data.source.db.dao.MovieDao
import com.djvmil.data.source.db.dao.MovieDaoImpl
import com.djvmil.data.source.db.util.DATABASE_NAME
import com.google.crypto.tink.Aead
import com.google.crypto.tink.aead.AeadConfig
import com.google.crypto.tink.aead.AesGcmKeyManager
import com.google.crypto.tink.integration.android.AndroidKeysetManager
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import java.io.File

private fun provideAead(context: Context): Aead {
    AeadConfig.register()

    return AndroidKeysetManager.Builder()
        .withSharedPref(context, KEYSET_NAME, PREFERENCE_FILE)
        .withKeyTemplate(AesGcmKeyManager.aes256GcmTemplate())
        .withMasterKeyUri(MASTER_KEY_URI)
        .build()
        .keysetHandle
        .getPrimitive(Aead::class.java)
}


val dataModule = module {

    includes(dispatchersKoinModule)

    single<MovieRepository> { MovieRepositoryImpl(api = get(), dao = get(), dataStore = get()) }
    single<AuthRepository> { AuthRepositoryImpl(apiService = get()) }


    single { provideAead(get()) }
    //single { provideAead(androidContext()) }


    single {
        DataStoreFactory.create(
            produceFile = { File(androidContext().filesDir, "datastore/$DATASTORE_FILE") },
            serializer = AppSettingsSerializer(get())
        )
    }

    single<IAppSettingsDataStoreSource>{AppSettingsDataStoreSource(get(), get())}

    single {
        val driver: SqlDriver = AndroidSqliteDriver(
            DatabaseSource.Schema,
            androidContext(),
            DATABASE_NAME
        )
        DatabaseSource(driver)
    }

    single {
        HttpClient(Android) {
            install(Logging) {
                logger = CustomHttpLogger()
                level = LogLevel.ALL
                /*logger = object : Logger {
                    override fun log(message: String) {
                        Log.i("HttpClient", message)
                    }
                }*/
            }
            install(ResponseObserver) {
                onResponse { response ->
                    println("HTTP status: ${response.status.value}")
                }
            }

            install(DefaultRequest) {
                url(
                    host = Route.BASE_URL,
                    path = Route.URI_URL
                )
                header(HttpHeaders.ContentType, ContentType.Application.Json)
                header(HttpHeaders.Accept, ContentType.Application.Json)
            }
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }

        }
    }

    single<MovieDao> { MovieDaoImpl(db = get()) }
    single<CommentDao> { CommentDaoImpl(db = get()) }
    single<ApiService> { ApiServiceImpl(httpClient = get()) }
}