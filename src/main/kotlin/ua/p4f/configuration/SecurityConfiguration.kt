package ua.p4f.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.DelegatingPasswordEncoder
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfiguration {

    @Bean
    fun securityFilterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
        return httpSecurity.cors { it.disable() }
            .csrf { it.disable() }
            .authorizeHttpRequests { it.anyRequest().hasRole("USER") }
            .formLogin { it.permitAll() }
            .build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return DelegatingPasswordEncoder(
            "bcrypt",
            mapOf(
                "NOOP" to NoOpPasswordEncoder.getInstance(),
                "bcrypt" to BCryptPasswordEncoder(10),
            )
        )
    }

}