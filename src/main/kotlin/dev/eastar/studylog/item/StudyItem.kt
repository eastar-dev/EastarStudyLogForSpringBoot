package dev.eastar.studylog.item

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "studylog")
data class StudyItem(
    var _id: String?,
    var millisecond: Long = System.currentTimeMillis(),
    var push: Long = 0L,
    var team: String,
    var username: String,
    var title: String,
    var content: String,
    var test: Int
)
