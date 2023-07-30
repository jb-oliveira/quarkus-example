package org.jb.userapi.application.repository

import org.jb.userapi.domain.User

interface UserRepository {
    fun insert(input: User)

}