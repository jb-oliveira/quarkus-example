package com.jb.userapi.application.usecases

import com.jb.userapi.application.repositories.UserRepository
import com.jb.userapi.domain.User
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional


@ApplicationScoped
class InsertUser {
    @Inject
    lateinit var repository: UserRepository

    @Transactional
    fun execute(input: User): User {
        input.validate()
        repository.insert(input)
        return input
    }
}