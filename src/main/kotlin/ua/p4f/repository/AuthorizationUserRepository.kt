package ua.p4f.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ua.p4f.domain.AuthorizationUser

@Repository
interface AuthorizationUserRepository : JpaRepository<AuthorizationUser, Long> {

    fun findByUsername(username: String): AuthorizationUser?
}