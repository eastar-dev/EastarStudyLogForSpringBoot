package dev.eastar.studylog.item

import org.springframework.data.mongodb.core.aggregation.DateOperators

data class StudyItem(var _id: String?, var nick: String = "noname", var title: String, var content: String, var millisecond: Long = System.currentTimeMillis())





