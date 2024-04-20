package com.djvmil.data.source.datastore.crypto

import com.google.crypto.tink.Aead

class Crypto (
    private val aead: Aead
) : ICrypto {
    override fun encrypt(text: ByteArray): ByteArray {
        return aead.encrypt(text, null)
    }

    override fun decrypt(encryptedData: ByteArray): ByteArray {
        return if (encryptedData.isNotEmpty()) {
            aead.decrypt(encryptedData, null)
        } else {
            encryptedData
        }
    }
}