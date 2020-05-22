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

    //@Scheduled(cron = "0 * * * * *")//매 번 0초가 될때
    @Scheduled(fixedDelay = 10000)
    fun scheduled() {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
        val now = Date()
        val strDate = sdf.format(now)
        println("Java cron job expression:: $strDate")
    }
}
