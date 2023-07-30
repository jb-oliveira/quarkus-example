package org.jb.userapi.infra.resources

import jakarta.inject.Inject
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.jb.userapi.application.usecases.InsertUser
import org.jb.userapi.infra.resources.dto.UserDto

@Path("/api/V1/users")
class UserResource {
    @Inject
    lateinit var insertUser: InsertUser

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun adicionarCliente(input: UserDto): Response {
        val result = insertUser.execute(input.toUser())
        return Response.ok(UserDto(result)).status(Response.Status.CREATED).build()
    }

}