package dev.eastar.studylog.login

import org.springframework.data.mongodb.repository.MongoRepository


interface LoginRepository : MongoRepository<LoginModel, String> {
    fun findByUsernameAndPassword(username: String,
                                  password: String): MutableList<LoginModel>

    fun findByUsername(username: String): MutableList<LoginModel>
}
