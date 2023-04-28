package ua.p4f.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table

@Entity
@Table(name = "roles")
data class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_sequence_generator")
    @SequenceGenerator(name = "role_sequence_generator", sequenceName = "roles_sequence", initialValue = 1, allocationSize = 1)
    val id: Long,
    val name: String
)
