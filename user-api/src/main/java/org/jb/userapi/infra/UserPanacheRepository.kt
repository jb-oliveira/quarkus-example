package org.jb.userapi.infra

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import org.jb.userapi.application.repository.UserRepository
import org.jb.userapi.domain.User

@ApplicationScoped
class UserPanacheRepository : PanacheRepository<User>, UserRepository {
    override fun insert(input: User) {
        persist(input)
    }
}