package com.jb.userapi.infra.resources.dto

import com.jb.userapi.domain.Address
import com.jb.userapi.domain.Cpf
import com.jb.userapi.domain.User
import com.jb.userapi.domain.UserStatus
import com.jb.userapi.infra.resources.serialization.LocalDateSerializer
import kotlinx.serialization.Serializable
import java.time.LocalDate
import java.util.*

@Serializable
@DefaultConstructor
data class UserInputDto(
    var name: String,
    @Serializable(with = LocalDateSerializer::class)
    var birth: LocalDate,
    var login: String,
    var password: String,
    var status: String,
    var cpf: String,
    var street: String,
    var city: String,
    var state: String,
    var zip: String

) {
    fun toUser(): User {
        return User(
            null,
            name,
            birth,
            login,
            password,
            UserStatus.fromString(status),
            Cpf(cpf),
            Address(street, city, state, zip)
        )
    }
}