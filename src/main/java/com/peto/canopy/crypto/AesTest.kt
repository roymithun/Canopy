package com.peto.canopy.crypto

import javax.crypto.spec.IvParameterSpec

class AesTest {
    companion object {
        fun encrypt() : String? {

            // initial vector
            val iv = byteArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
            val ivParameterSpec = IvParameterSpec(iv)

//            val secretKeyFactory = SecretKeyFactory.getInstance()
            return null
        }
    }
}