package com.djvmil.data.source.datastore.crypto

interface ICrypto {
    fun encrypt(text: ByteArray): ByteArray

    fun decrypt(encryptedData: ByteArray): ByteArray
}