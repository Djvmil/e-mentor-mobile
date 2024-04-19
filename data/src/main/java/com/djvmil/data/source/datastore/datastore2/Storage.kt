package com.djvmil.data.source.datastore.datastore2

import kotlinx.coroutines.flow.Flow

interface Storage {
    fun <T> insert(data: T): Flow<Int>

    fun <T> insertAll(data: List<T>): Flow<Int>

    fun <T> get(where: (T) -> Boolean): Flow<T>

    fun <T> getAll(): Flow<List<T>>

    fun <T> clearAll(): Flow<Int>
}