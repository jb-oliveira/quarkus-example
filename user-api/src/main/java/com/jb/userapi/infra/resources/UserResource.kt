package com.jb.userapi.infra.resources

import com.jb.userapi.application.usecases.InsertUser
import com.jb.userapi.application.usecases.ListUsers
import com.jb.userapi.infra.resources.dto.UserDto
import jakarta.inject.Inject
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

@Path("/api/V1/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class UserResource {
    @Inject
    lateinit var insertUser: InsertUser

    @Inject
    lateinit var listUsers: ListUsers

    @GET
    fun listUsers(): List<UserDto> {
        return listUsers.execute().map { user -> UserDto(user) }
    }

    @POST
    fun insertUser(input: UserDto): Response {
        val result = insertUser.execute(input.toUser())
        return Response.ok(UserDto(result)).status(Response.Status.CREATED).build()
    }

}