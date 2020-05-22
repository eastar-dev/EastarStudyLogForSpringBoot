package dev.eastar.studylog.item

import org.springframework.data.mongodb.repository.MongoRepository


data class StudyItem(
    var _id: String?,
    var nick: String = "noname",
    var title: String,
    var content: String,
    var millisecond: Long = System.currentTimeMillis(),
    var push: Long = Long.MAX_VALUE
)
