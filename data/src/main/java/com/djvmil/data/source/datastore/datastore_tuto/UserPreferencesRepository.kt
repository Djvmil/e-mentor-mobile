package com.djvmil.data.source.datastore.datastore_tuto

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

enum class StepsStarting {
    NONE,
    ON_BOARDING,
    ON_HOME_USER

}

data class UserPreferences(
    val accessToken: String?,
    val isLogin: Boolean,
    val stepsStarting: StepsStarting
)

// Build the DataStore
private val Context.userPreferencesStore: DataStore<UserPreferences> by dataStore(
    fileName = "DATA_STORE_FILE_NAME",
    serializer = UserPreferencesSerializer)


/**
 * Class that handles saving and retrieving user preferences
 */
class UserPreferencesRepository(private val dataStore: DataStore<Preferences>) {

    private val TAG: String = "UserPreferencesRepo"

    private object PreferencesKeys {
        val ACCESS_TOKEN = stringPreferencesKey("access_token")
        val STEPS_STARTING = stringPreferencesKey("steps_starting")
        val IS_LOGIN = booleanPreferencesKey("is_login")
    }

    /**
     * Get the user preferences flow.
     */
    val userPreferencesFlow: Flow<UserPreferences> = dataStore.data
        .catch { exception ->
            // dataStore.data throws an IOException when an error is encountered when reading data
            if (exception is IOException) {
                Log.e(TAG, "Error reading preferences.", exception)
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { preferences ->
            mapUserPreferences(preferences)
        }

    suspend fun updateToken(token: String) {
        dataStore.edit { preferences ->
            try {
                preferences[PreferencesKeys.ACCESS_TOKEN] = token
            } catch (e: IOException) {
                // Handle error
            }
        }
    }

    suspend fun updateIsLogin(isLogin: Boolean) {
        try {
            dataStore.edit { preferences ->
                preferences[PreferencesKeys.IS_LOGIN] = isLogin
            }
        } catch (e: IOException) {
            // Handle error
        }
    }

    suspend fun fetchInitialPreferences() =
        mapUserPreferences(dataStore.data.first().toPreferences())


    private fun mapUserPreferences(preferences: Preferences): UserPreferences {
        // Get the sort order from preferences and convert it to a [SortOrder] object
        val stepsStarting = StepsStarting.valueOf(
            preferences[PreferencesKeys.STEPS_STARTING] ?: StepsStarting.NONE.name
        )
        val accessToken = preferences[PreferencesKeys.ACCESS_TOKEN]
        val isLogin = preferences[PreferencesKeys.IS_LOGIN] ?: false

        return UserPreferences(accessToken = accessToken, stepsStarting = stepsStarting, isLogin = isLogin)
    }



}