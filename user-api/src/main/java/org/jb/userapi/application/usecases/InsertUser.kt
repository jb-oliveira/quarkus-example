package org.jb.userapi.application.usecases

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import org.jb.userapi.application.repositories.UserRepository
import org.jb.userapi.domain.User


@ApplicationScoped
class InsertUser {
    @Inject
    lateinit var repository: UserRepository
    fun execute(input: User): User {
        input.validate()
        repository.insert(input)
        return input
    }
}