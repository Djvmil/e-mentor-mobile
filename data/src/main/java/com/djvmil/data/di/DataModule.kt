package com.djvmil.data.di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.djvmil.DatabaseSource
import com.djvmil.data.repository.AuthRepository
import com.djvmil.data.repository.AuthRepositoryImpl
import com.djvmil.data.repository.MovieRepository
import com.djvmil.data.repository.MovieRepositoryImpl
import com.djvmil.data.source.api.api.ApiService
import com.djvmil.data.source.api.api.ApiServiceImpl
import com.djvmil.data.source.api.util.CustomHttpLogger
import com.djvmil.data.source.api.util.Route
import com.djvmil.data.source.datastore.DataStoreSource
import com.djvmil.data.source.db.dao.CommentDao
import com.djvmil.data.source.db.dao.CommentDaoImpl
import com.djvmil.data.source.db.dao.MovieDao
import com.djvmil.data.source.db.dao.MovieDaoImpl
import com.djvmil.data.source.db.util.DATABASE_NAME
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single<MovieRepository> { MovieRepositoryImpl(api = get(), dao = get(), dataStore = get()) }
    single<AuthRepository> { AuthRepositoryImpl(apiService = get()) }

    single { DataStoreSource() }

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

    single { Dispatchers.Default }
    single<ApiService> { ApiServiceImpl(httpClient = get()) }
}