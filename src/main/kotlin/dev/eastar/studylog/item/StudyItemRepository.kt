package dev.eastar.studylog.item

import org.springframework.data.mongodb.repository.MongoRepository


interface StudyItemRepository : MongoRepository<StudyItem, String>
{
    fun findByPushGreaterThan(pushMillisecond: Int): MutableList<StudyItem>
    fun findByPushLessThan(pushMillisecond: Int): MutableList<StudyItem>
    fun findByTitleLessThan(pushMillisecond: Int): MutableList<StudyItem>
    fun findByPushNotNull()

}
