package com.jb.userapi.domain

import jakarta.persistence.Embeddable

@Embeddable
data class Cpf(
    var value: String
) {


    fun validate(): Boolean {
        val cpfOnlyDigits = value.replace("[^0-9]".toRegex(), "")
        if (cpfOnlyDigits.length != 11) {
            return false
        }
        if (cpfOnlyDigits.matches("(\\d)\\1{10}".toRegex())) {
            return false
        }
        val d1 = checkDigit(cpfOnlyDigits.substring(0, 9))
        val d2 = checkDigit(cpfOnlyDigits.substring(0, 9) + d1)
        return cpfOnlyDigits == cpfOnlyDigits.substring(0, 9) + d1 + d2
    }

    private fun checkDigit(part: String): Int {
        var sum = 0
        var height = part.length + 1
        for (i in 0 until part.length) {
            sum += part.substring(i, i + 1).toInt() * height--
        }
        val modulus = sum % 11
        return if (modulus < 2) 0 else 11 - modulus
    }
}