package org.jb.userapi.infra.resources.dto

import jakarta.persistence.*
import org.jb.userapi.domain.Address
import org.jb.userapi.domain.Cpf
import org.jb.userapi.domain.User
import org.jb.userapi.domain.UserStatus
import java.time.LocalDate
import java.util.*

data class UserDto(
    var id: String,
    var name: String,
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
    constructor(user: User) : this(
        user.id.toString(),
        user.name,
        user.birth,
        user.login,
        user.password,
        user.status.name,
        user.cpf.value,
        user.address.street,
        user.address.city,
        user.address.state,
        user.address.zip,
    )

    fun toUser(): User {
        return User(
            UUID.fromString(id),
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
