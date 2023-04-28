package ua.p4f.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ua.p4f.domain.AuthorizationUser
import ua.p4f.service.AuthorizationUserService

@RestController
@RequestMapping("/authorization-users")
class AuthorizationUserController(
    private val authorizationUserService: AuthorizationUserService,
) {

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): AuthorizationUser {
        return authorizationUserService.getUserById(id)
    }
}