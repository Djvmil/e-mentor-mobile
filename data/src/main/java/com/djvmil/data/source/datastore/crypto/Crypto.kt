package com.djvmil.data.source.datastore.crypto

interface Crypto {
    fun encrypt(text: ByteArray): ByteArray

    fun decrypt(encryptedData: ByteArray): ByteArray
}