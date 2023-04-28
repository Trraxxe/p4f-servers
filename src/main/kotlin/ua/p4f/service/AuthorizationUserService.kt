package ua.p4f.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import ua.p4f.domain.AuthorizationUser
import ua.p4f.repository.AuthorizationUserRepository

@Service
class AuthorizationUserService(
    private val authorizationUserRepository: AuthorizationUserRepository,
) : UserDetailsService {

    fun getUserById(id: Long): AuthorizationUser {
        return authorizationUserRepository.findByIdOrNull(id)!!
    }

    override fun loadUserByUsername(username: String): UserDetails {
        return authorizationUserRepository.findByUsername(username)
            ?: throw UsernameNotFoundException("Username $username is not found")
    }
}