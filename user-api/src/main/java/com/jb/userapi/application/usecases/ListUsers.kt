package com.jb.userapi.application.usecases

import com.jb.userapi.application.repositories.UserRepository
import com.jb.userapi.domain.User
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject

@ApplicationScoped

class ListUsers {
    @Inject
    lateinit var repository: UserRepository

    fun execute(): List<User> {
        return repository.list()
    }
}