package org.jb.userapi.infra.repositories

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import org.jb.userapi.application.repositories.UserRepository
import org.jb.userapi.domain.User

@ApplicationScoped
class UserPanacheRepository : PanacheRepository<User>, UserRepository {
    override fun insert(input: User) {
        persist(input)
    }
}