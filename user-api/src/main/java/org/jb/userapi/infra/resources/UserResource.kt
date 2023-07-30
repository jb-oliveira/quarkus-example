package org.jb.userapi.infra.resources

import jakarta.inject.Inject
import jakarta.ws.rs.Path
import org.jb.userapi.application.usecases.InsertUser

@Path("/api/V1/users")
class UserResource {
    @Inject
    lateinit var insertUser: InsertUser

}