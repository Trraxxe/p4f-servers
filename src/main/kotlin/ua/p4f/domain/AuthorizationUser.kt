package ua.p4f.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToOne
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table

@Entity
@Table(name = "users")
data class AuthorizationUser(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authorization_users_sequence_generator")
    @SequenceGenerator(
        name = "authorization_users_sequence_generator",
        sequenceName = "users_sequence",
        initialValue = 1,
        allocationSize = 1
    )
    val id: Long,
    val username: String,
    @JoinTable(
        name = "users_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    @ManyToOne
    val role: Role,
)
