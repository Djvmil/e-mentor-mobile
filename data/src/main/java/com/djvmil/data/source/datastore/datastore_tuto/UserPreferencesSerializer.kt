package com.djvmil.data.source.datastore.datastore_tuto


import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream


object UserPreferencesSerializer : Serializer<UserPreferences> {
    override val defaultValue: UserPreferences
        get() = TODO("Not yet implemented")

    //override val defaultValue: UserPreferences = UserPreferences.getDefaultInstance()
    override suspend fun readFrom(input: InputStream): UserPreferences {
        TODO("Not yet implemented")
    }

    override suspend fun writeTo(t: UserPreferences, output: OutputStream) {
        TODO("Not yet implemented")
    }
    /*
        override suspend fun readFrom(input: InputStream): UserPreferences {
            try {
                return UserPreferences.parseFrom(input)
            } catch (exception: InvalidProtocolBufferException) {
                throw CorruptionException("Cannot read proto.", exception)
            }
        }

        override suspend fun writeTo(t: UserPreferences, output: OutputStream) =
            t.writeTo(output)*/
}