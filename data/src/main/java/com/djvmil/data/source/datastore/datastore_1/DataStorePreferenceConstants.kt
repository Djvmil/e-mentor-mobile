package com.djvmil.data.source.datastore.datastore_1

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object DataStorePreferenceConstants {

    val BOOLEAN_KEY = booleanPreferencesKey("BOOLEAN_KEY")
    val INT_KEY = intPreferencesKey("INT_KEY")
    val STRING_KEY = stringPreferencesKey("STRING_KEY")
    val LONG_KEY = longPreferencesKey("LONG_KEY")
    val DOUBLE_KEY = doublePreferencesKey("DOUBLE_KEY")

}