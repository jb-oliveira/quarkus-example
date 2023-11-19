package com.jb.userapi.infra.repositories

import com.jb.userapi.application.repositories.UserRepository
import com.jb.userapi.domain.User
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class UserPanacheRepository : PanacheRepository<User>, UserRepository {
    override fun insert(input: User) {
        persist(input)
    }

    override fun list(): List<User> {
        return findAll().list()
    }


}