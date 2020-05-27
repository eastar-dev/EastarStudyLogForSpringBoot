package dev.eastar.studylog.login

import org.springframework.data.mongodb.core.mapping.Document

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
@Document(collection = "user")
data class LoginModel(
    val _id: String? = null,
    val studyGroup: String? = null,
    val username: String,
    val password: String? = null
)