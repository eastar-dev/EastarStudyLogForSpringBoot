package dev.eastar.studylog.notification

import dev.eastar.studylog.item.StudyItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.text.SimpleDateFormat
import java.util.*


@Component
class NotificationController {
    @Autowired
    lateinit var repository: StudyItemRepository

    @Scheduled(fixedDelay = 10000)
    fun scheduled() {
        println(SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Date()) + " [send nitification]")
    }
}
