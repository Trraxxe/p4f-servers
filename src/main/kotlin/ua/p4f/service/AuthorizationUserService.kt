package ua.p4f.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ua.p4f.domain.AuthorizationUser
import ua.p4f.repository.AuthorizationUserRepository

@Service
class AuthorizationUserService(
    private val authorizationUserRepository: AuthorizationUserRepository,
) {

    fun getUserById(id: Long): AuthorizationUser {
        return authorizationUserRepository.findByIdOrNull(id)!!
    }
}