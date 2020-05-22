package dev.eastar.studylog

import dev.eastar.studylog.item.StudyItem
import org.springframework.data.mongodb.repository.MongoRepository


interface StudyItemRepository : MongoRepository<StudyItem, String> {
    fun findByPushIs(push: Long): MutableList<StudyItem>
}
