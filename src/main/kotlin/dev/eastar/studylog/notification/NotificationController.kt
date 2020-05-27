@file:Suppress("unused")

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

    @Autowired
    lateinit var push: AndroidPushNotificationsService

    @Scheduled(fixedDelay = 10000)
    fun scheduled() {
        println(SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Date()) + "==push start====================================================================")
        repository.findByPushIs(0L).map {
            it.apply { push = System.currentTimeMillis() }
        }.forEach {
            repository.save(it)
            println("[send] $it")
            push.send("[send] $it")
        }
        println(SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Date()) + "==push end  ====================================================================")
    }
}
