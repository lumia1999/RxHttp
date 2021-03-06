package com.github.kongpf8848.rxhttp.util

import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStream
import java.nio.charset.StandardCharsets
import java.security.MessageDigest

object Md5Util {

    fun getMD5(str: String): String {
        try {
            val md5 = MessageDigest.getInstance("MD5")
            val bytes = md5.digest(str.toByteArray(StandardCharsets.UTF_8))
            val HEX_DIGITS = "0123456789ABCDEF".toCharArray()
            val result = StringBuilder(bytes.size * 2)
            for (i in bytes.indices) {
                result.append(HEX_DIGITS[(bytes[i].toInt() shr 4) and 0x0f])
                result.append(HEX_DIGITS[bytes[i].toInt() and 0x0f])
            }
            return result.toString()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ""
    }

    fun getMD5(file: File?): String? {
        var hash: String? = null
        if (file == null || !file.exists()) {
            return hash
        }
        var `is`: InputStream? = null
        try{
            val messageDigest = MessageDigest.getInstance("MD5")
            `is` = FileInputStream(file)
            val buffer = ByteArray(1024)
            var len = -1
            while (`is`.read(buffer).also { len = it } != -1) {
                messageDigest.update(buffer, 0, len)
            }
            val bytes = messageDigest.digest()
            hash = byteArray2HexString(bytes)
        } catch (e: Exception) {
        } finally {
            if (`is` != null) {
                try {
                    `is`.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
        return hash
    }

    //字节数组转化为16进制字符串
    fun byteArray2HexString(bArr: ByteArray): String {
        val builder = StringBuilder()
        bArr.forEach {
            builder.append(String.format("%02X", it))
        }
        return builder.toString()
    }
}