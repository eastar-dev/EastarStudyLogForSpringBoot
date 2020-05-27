package dev.eastar.studylog.error

import org.springframework.boot.web.error.ErrorAttributeOptions
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes
import org.springframework.stereotype.Component
import org.springframework.web.context.request.WebRequest

@Component
class StudyErrorAttributes : DefaultErrorAttributes() {
    override fun getErrorAttributes(webRequest: WebRequest?, options: ErrorAttributeOptions?): MutableMap<String, Any> {
        //webRequest?.run {
        //    println("$locale ")
        //    println("$remoteUser ")
        //    println("$isSecure ")
        //    println("$sessionId ")
        //    println("$userPrincipal ")
        //    println("$sessionMutex ")
        //    headerNames.forEach {
        //        println("$it ${getHeader(it)} ")
        //    }
        //    parameterMap.forEach {
        //        println("${it.key} ${it.value.first()} ")
        //    }
        //}
        //response.entries.forEach {
        //    println("${it.key} ${it.value} ")
        //}

        val response = super.getErrorAttributes(webRequest, options)
        response["status"] = kotlin.runCatching { response["status"].toString().toInt() }.getOrDefault(999) + 1000
        return response
    }
}