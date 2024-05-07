package com.djvmil.entretienmentor.core.data.source.datastore

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import com.djvmil.entretienmentor.core.common.dispatcher.AppDispatchers
import com.djvmil.entretienmentor.core.data.source.datastore.model.APP_SETTING_NULL
import com.djvmil.entretienmentor.core.data.source.datastore.model.AppSettings
import com.djvmil.entretienmentor.core.data.source.datastore.model.AppTheme
import com.djvmil.entretienmentor.core.data.source.datastore.model.StepsStarting
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext

class AppSettingsDataStoreSourceImpl (
    private val appSettings: DataStore<AppSettings>,
    private val appDispatchers: AppDispatchers
): AppSettingsDataStoreSource {
    override fun appSetting() = appSettings.data
        //.distinctUntilChanged()
        .flowOn(appDispatchers.io)

    override suspend fun update(transform: suspend (current: AppSettings?) -> AppSettings?) =
        withContext(appDispatchers.io) {
            appSettings.updateData { current ->
                transform(current.takeIf { it != APP_SETTING_NULL }) ?: APP_SETTING_NULL
            }
        }

    override suspend fun setTheme(theme: AppTheme): Unit = withContext(appDispatchers.io) {
        appSettings.updateData {
            it.copy(theme = theme)
        }
    }



    override fun getTheme() = appSettings.data
        .onEach { Log.d("getTheme", "getTheme=${it.theme}") }
        .map { v -> v.theme}
        .catch { cause: Throwable ->
            if (cause is IOException) {
                emit(AppTheme.default())
            } else {
                throw cause
            }
        }
        .flowOn(appDispatchers.io)

    override suspend fun setIsLogin(status: Boolean): Unit = withContext(appDispatchers.io)  {
        appSettings.updateData {
            it.copy(isLogin = status)
        }
    }

    override suspend fun setLogin(status: Boolean, accessToken: String, steps: StepsStarting) {
        appSettings.updateData {
            it.copy(
                isLogin = status,
                accessToken = accessToken,
                stepsStarting = steps
            )
        }
    }

    override fun isLogin() = appSettings.data
        .onEach { Log.d("getTheme", "getTheme=${it.theme}") }
        .map { v -> v.isLogin }
        .catch { cause: Throwable ->
            if (cause is IOException) {
                emit(false)
            } else {
                throw cause
            }
        }
        .flowOn(appDispatchers.io)

    override suspend fun setStepsStarting(steps: StepsStarting): Unit = withContext(appDispatchers.io) {
        appSettings.updateData {
            it.copy(stepsStarting = steps)
        }
    }

    override fun getStepsStarting() = appSettings.data
        .onEach { Log.d("getTheme", "getTheme=${it.theme}") }
        .map { v -> v.stepsStarting }
        .catch { cause: Throwable ->
            if (cause is IOException) {
                emit(StepsStarting.ON_BOARDING)
            } else {
                throw cause
            }
        }
        .flowOn(appDispatchers.io)

    override suspend fun setAccessToken(accessToken: String): Unit = withContext(appDispatchers.io)  {
        appSettings.updateData {
            it.copy(accessToken = accessToken)
        }
    }

    override fun getAccessToken() = appSettings.data
        .onEach { Log.d("getTheme", "getTheme = ${it.theme}") }
        .map { v -> v.accessToken }
        .catch { cause: Throwable ->
            if (cause is IOException) {
                emit(null)
            } else {
                throw cause
            }
        }
        .flowOn(appDispatchers.io)

    override suspend fun getAccessTokenForAuth(): String? = appSettings.data
        .onEach {
            Log.d("getTheme", "getTheme = ${it.theme}")
        }
        .map { v -> v.accessToken }
        .catch { cause: Throwable ->
            if (cause is IOException) {
                emit(null)
            } else {
                throw cause
            }
        }
        .flowOn(appDispatchers.io).first()

    companion object {
        const val DATASTORE_FILE = "app_settings.pb"
    }
}