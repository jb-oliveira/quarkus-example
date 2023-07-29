package org.jb.userapi.domain

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDate
import java.util.*


@Entity
class User {

    @Id
    @Column(name = "usr_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
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
}