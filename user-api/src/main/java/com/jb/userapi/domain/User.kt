package com.jb.userapi.domain

import jakarta.persistence.*
import java.time.LocalDate
import java.util.*


@Entity
@Table(name = "users")
data class User(
    @Id
    @Column(name = "usr_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID,

    @Column(name = "usr_name", nullable = false, length = 200)
    var name: String,

    @Column(name = "usr_birth", nullable = false)
    var birth: LocalDate,

    @Column(name = "usr_login", nullable = false, length = 50, unique = true)
    var login: String,

    @Column(name = "usr_password", nullable = false, length = 255)
    var password: String,

    @Column(name = "usr_status", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    var status: UserStatus,

    @Embedded
    @AttributeOverrides(
        value = [AttributeOverride(name = "value", column = Column(name = "usr_cpf", nullable = false, length = 11))]
    )
    var cpf: Cpf,

    @Embedded
    @AttributeOverrides(
        value = [
            AttributeOverride(name = "street", column = Column(name = "usr_street", nullable = false)),
            AttributeOverride(name = "city", column = Column(name = "usr_city", nullable = false)),
            AttributeOverride(name = "state", column = Column(name = "usr_state", nullable = false)),
            AttributeOverride(name = "zip", column = Column(name = "user_zip", nullable = false, length = 10))
        ]
    )
    var address: Address,
) {
    fun validate() {
        if (!cpf.validate()) throw IllegalArgumentException("Invalid CPF!")
    }

}