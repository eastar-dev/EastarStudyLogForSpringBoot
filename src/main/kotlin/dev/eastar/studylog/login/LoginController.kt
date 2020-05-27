@file:Suppress("unused")

package dev.eastar.studylog.login

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/login")
class LoginController {
    @Autowired
    lateinit var repository: LoginRepository

    companion object {
        val SORT = Sort.by(Sort.Direction.DESC, "millisecond")
    }

    @PostMapping(path = ["/login"], consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE])
    fun loginOrJoin(loginModel: LoginModel): Map<String, Any?> {
        val exists = findUser(loginModel.username)
        val id: String = if (exists)
            login(loginModel)
        else
            join(loginModel)
        return mapOf<String, Any?>("id" to id)
    }

    fun login(loginModel: LoginModel): String {
        loginModel.password ?: throw Exception("inout password")
        val user = repository.findByUsernameAndPassword(loginModel.username, loginModel.password)
        if (user.size > 1)
            throw Exception("multi user")

        if (user.size <= 0)
            throw Exception("password error")

        return user.first()._id!!
    }


    fun join(loginModel: LoginModel): String {
        return repository.save(loginModel)._id!!
    }

    fun findUser(username: String): Boolean {
        val count = repository.findByUsername(username).size
        println(count)
        if (count > 1)
            throw Exception("multi user")
        return count == 1
    }

    @RequestMapping(path = ["/all"])
    fun selectAll(): MutableList<LoginModel> = repository.findAll(SORT)

    @DeleteMapping(path = ["/all"])
    fun delete() = repository.deleteAll()

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception::class)
    fun error(e: Exception) = mutableMapOf("message" to e.message)

}
