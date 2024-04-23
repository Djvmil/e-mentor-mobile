package com.djvmil.core.crypto

interface Crypto {
    fun encrypt(text: ByteArray): ByteArray
    fun decrypt(encryptedData: ByteArray): ByteArray
}