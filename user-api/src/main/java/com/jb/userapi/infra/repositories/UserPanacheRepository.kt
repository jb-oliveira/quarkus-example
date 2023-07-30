package com.jb.userapi.infra.repositories

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import com.jb.userapi.application.repositories.UserRepository
import com.jb.userapi.domain.User

@ApplicationScoped
class UserPanacheRepository : PanacheRepository<User>, UserRepository {
    override fun insert(input: User) {
        persist(input)
    }
}