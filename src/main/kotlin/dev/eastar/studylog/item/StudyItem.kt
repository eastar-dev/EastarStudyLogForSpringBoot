package dev.eastar.studylog.item

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.web.bind.annotation.*

@Document(collation = "studyitem")
data class StudyItem(val id: String,val title: String, val content: String)





