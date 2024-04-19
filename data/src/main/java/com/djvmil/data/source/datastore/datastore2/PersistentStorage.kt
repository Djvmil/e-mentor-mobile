package com.djvmil.data.source.datastore.datastore2

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import java.lang.reflect.Type


class PersistentStorage constructor(
    private val gson: Gson,
    private val type: Type,
    private val preferenceKey: Preferences.Key<String>,
    private val dataStore: DataStore<Preferences>
) : Storage {

    override fun <T> insert(data: T): Flow<Int> {
        return flow {
            val cachedDataClone = getAll<T>().first().toMutableList()
            cachedDataClone.add(data)
            dataStore.edit {
                val jsonString = gson.toJson(cachedDataClone, type)
                it[preferenceKey] = jsonString
                emit(OPERATION_SUCCESS)
            }
        }
    }

    override fun <T> insertAll(data: List<T>): Flow<Int> {
        return flow {
            val cachedDataClone = getAll<T>().first().toMutableList()
            cachedDataClone.addAll(data)
            dataStore.edit {
                val jsonString = gson.toJson(cachedDataClone, type)
                it[preferenceKey] = jsonString
                emit(OPERATION_SUCCESS)
            }
        }
    }

    override fun <T> getAll(): Flow<List<T>> {
        return dataStore.data.map { preferences ->
            val jsonString = preferences[preferenceKey] ?: EMPTY_JSON_STRING
            val elements = gson.fromJson<List<T>>(jsonString, type)
            elements
        }
    }

    override fun <T> clearAll(): Flow<Int> {
        return flow {
            dataStore.edit {
                it.remove(preferenceKey)
                emit(OPERATION_SUCCESS)
            }
        }
    }

    override fun <T> get(where: (T) -> Boolean): Flow<T> {
        return flow {
            val data = getAll<T>().first().first(where)
            emit(data)
        }
    }

    companion object {
        private const val OPERATION_SUCCESS = 1
        private const val OPERATION_FAILURE = -1
        private const val EMPTY_JSON_STRING = "[]"
    }
}