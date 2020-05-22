package dev.eastar.studylog.item


data class StudyItem(
    var _id: String?,
    var millisecond: Long = System.currentTimeMillis(),
    var push: Long = 0L,
    var nick: String = "noname",
    var title: String,
    var content: String
)
