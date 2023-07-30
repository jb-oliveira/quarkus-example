package org.jb.userapi.domain

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.lang.IllegalArgumentException
import java.time.LocalDate
import java.util.*


@Entity
@Table(name = "users")
open class User {

    @Id
    @Column(name = "usr_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null

    @Column(name = "usr_name", nullable = false, length = 200)
    lateinit var name: String

    @Column(name = "usr_birth", nullable = false)
    lateinit var birth: LocalDate

    @Column(name = "usr_login", nullable = false, length = 50)
    lateinit var login: String

    @Column(name = "usr_password", nullable = false, length = 255)
    lateinit var password: String

    @Column(name = "usr_status", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    lateinit var status: UserStatus

    @Embedded
    @AttributeOverrides(
        value = [AttributeOverride(name = "value", column = Column(name = "usr_cpf", nullable = false, length = 11))]
    )
    lateinit var cpf: Cpf

    fun validate() {
        if (!cpf.validate()) throw IllegalArgumentException("Invalid CPF!")
    }
}