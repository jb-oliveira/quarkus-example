package com.jb.userapi.application.repositories

import com.jb.userapi.domain.User

interface UserRepository {
    fun insert(input: User)
    fun list() : List<User>

}