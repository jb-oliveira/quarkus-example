package com.jb.userapi.infra.resources.dto

import com.jb.userapi.domain.User
import com.jb.userapi.infra.resources.serialization.LocalDateSerializer
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
@DefaultConstructor
data class UserOutputDto(
    var id: String,
    var name: String,
    @Serializable(with = LocalDateSerializer::class)
    var birth: LocalDate,
    var login: String,
    var status: String,
    var cpf: String,
    var street: String,
    var city: String,
    var state: String,
    var zip: String? = null

) {
    constructor(user: User) : this(
        user.id.toString(),
        user.name,
        user.birth,
        user.login,
        user.status.name,
        user.cpf.value,
        user.address.street,
        user.address.city,
        user.address.state,
        user.address.zip,
    )
}
