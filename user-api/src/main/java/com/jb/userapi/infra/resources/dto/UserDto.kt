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
data class UserDto(
    var id: String? = null,
    var name: String? = null,
    @Serializable(with = LocalDateSerializer::class)
    var birth: LocalDate? = null,
    var login: String? = null,
    var password: String? = null,
    var status: String? = null,
    var cpf: String? = null,
    var street: String? = null,
    var city: String? = null,
    var state: String? = null,
    var zip: String? = null

) {
    constructor(user: User) : this(
        user.id.toString(),
        user.name,
        user.birth,
        user.login,
        user.password,
        user.status!!.name,
        user.cpf!!.value,
        user.address!!.street,
        user.address!!.city,
        user.address!!.state,
        user.address!!.zip,
    )


    fun toUser(): User {
        return User(
            null,
            name.toString(),
            LocalDateSerializer.toLocalDate(birth.toString()),
            login.toString(),
            password.toString(),
            UserStatus.fromString(status.toString()),
            Cpf(cpf.toString()),
            Address(street.toString(), city.toString(), state.toString(), zip.toString())
        )
    }
}
