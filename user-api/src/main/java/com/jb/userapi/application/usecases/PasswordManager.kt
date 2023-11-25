package com.jb.userapi.application.usecases

import com.jb.userapi.application.exceptions.PasswordErrorException
import jakarta.enterprise.context.ApplicationScoped
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom

private const val algorithm = "SHA-256"
@ApplicationScoped
class PasswordManager {
    fun hashPassword(password: String): String {
        return try {
            // Use a secure random salt
            val random = SecureRandom()
            val salt = ByteArray(16)
            random.nextBytes(salt)

            // Combine password and salt and hash them
            val md = MessageDigest.getInstance(algorithm)
            md.update(salt)
            val hashedPassword = md.digest(password.toByteArray())

            // Combine salt and hashed password and convert to a string for storage
            val sb = StringBuilder()
            for (b in salt) {
                sb.append(String.format("%02x", b))
            }
            for (b in hashedPassword) {
                sb.append(String.format("%02x", b))
            }
            sb.toString()
        } catch (e: NoSuchAlgorithmException) {
            throw PasswordErrorException()
        }
    }

    fun verifyPassword(enteredPassword: String, storedPassword: String): Boolean {
        return try {
            // Extract salt and hashed password from stored string
            val salt = hexStringToByteArray(storedPassword.substring(0, 32))
            val storedHash = hexStringToByteArray(storedPassword.substring(32))

            // Combine entered password and salt and hash them
            val md = MessageDigest.getInstance(algorithm)
            md.update(salt)
            val enteredHash = md.digest(enteredPassword.toByteArray())

            // Compare the stored and entered hashes
            MessageDigest.isEqual(storedHash, enteredHash)
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
            false
        }
    }

    private fun hexStringToByteArray(hex: String): ByteArray {
        val len = hex.length
        val data = ByteArray(len / 2)
        var i = 0
        while (i < len) {
            data[i / 2] = ((((hex[i].digitToIntOrNull(16) ?: (-1 shl 4)) + hex[i + 1].digitToIntOrNull(16)!!) ?: -1)).toByte()
            i += 2
        }
        return data
    }
}