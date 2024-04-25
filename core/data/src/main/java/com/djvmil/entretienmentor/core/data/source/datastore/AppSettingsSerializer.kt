package com.djvmil.data.source.datastore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.djvmil.core.crypto.CryptoImpl
import com.djvmil.data.source.datastore.model.APP_SETTING_NULL
import com.djvmil.data.source.datastore.model.AppSettings
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerializationException
import kotlinx.serialization.protobuf.ProtoBuf
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

@OptIn(ExperimentalSerializationApi::class)
class AppSettingsSerializer(private val crypto: CryptoImpl): Serializer<AppSettings> {
    override val defaultValue: AppSettings = APP_SETTING_NULL

    override suspend fun readFrom(input: InputStream): AppSettings {
        return try {
            val encryptedInput = input.readBytes()

            val decryptedInput = if (encryptedInput.isNotEmpty()) {
                crypto.decrypt(encryptedInput)
            } else {
                encryptedInput
            }

            ProtoBuf.decodeFromByteArray(AppSettings.serializer(), decryptedInput)

        } catch(e: IOException) {
            throw CorruptionException("Error deserializing proto", e)
        } catch(e: SerializationException) {
            throw CorruptionException("Error deserializing proto", e)
        }
    }

    override suspend fun writeTo(appSettings: AppSettings, output: OutputStream) {
        try {
            val byteArray = ProtoBuf.encodeToByteArray(AppSettings.serializer(), appSettings)
            val encryptedBytes = crypto.encrypt(byteArray)

            output.write(encryptedBytes)
        } catch(e: IOException) {
            throw CorruptionException("Error serializing proto", e)
        } catch(e: SerializationException) {
            throw CorruptionException("Error serializing proto", e)
        }
    }
}
