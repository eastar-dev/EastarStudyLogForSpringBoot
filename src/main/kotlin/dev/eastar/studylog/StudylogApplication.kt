package dev.eastar.studylog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class StudylogApplication

fun main(args: Array<String>) {
    runApplication<StudylogApplication>(*args)
}