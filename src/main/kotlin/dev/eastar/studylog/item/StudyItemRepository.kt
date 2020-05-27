package dev.eastar.studylog.item

import dev.eastar.studylog.item.StudyItem
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository


interface StudyItemRepository : MongoRepository<StudyItem, String> {
    fun findByPushIs(push: Long): MutableList<StudyItem>
    fun findByMillisecondLessThan(millisecond: Long, pageable: Pageable): Page<StudyItem>
    fun findByTestLessThan(test: Int, pageable: Pageable): Page<StudyItem>
}
