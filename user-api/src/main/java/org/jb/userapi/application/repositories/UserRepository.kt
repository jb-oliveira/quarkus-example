package org.jb.userapi.application.repositories

import org.jb.userapi.domain.User

interface UserRepository {
    fun insert(input: User)

}