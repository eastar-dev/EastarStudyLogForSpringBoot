package dev.eastar.studylog.item

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*


interface StudyItemRepository : MongoRepository<StudyItem, String>

@RestController
@RequestMapping("/item")
class ContentController {

    @Autowired
    lateinit var repository: StudyItemRepository

    @RequestMapping(method = [RequestMethod.GET, RequestMethod.POST], path = ["/{id}"])
    fun post(@PathVariable(value = "id") id: Long): String = "post item $id"

    @RequestMapping(method = [RequestMethod.GET, RequestMethod.POST])
    fun post(): String {
        val items = repository.findAll()
        items.forEach {
            println(it.toString())
        }
        return items.toString()
    }

    @PutMapping(consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE])
    @ResponseBody
    fun put(studyItem: StudyItem): String {
        repository.insert(studyItem)
        return studyItem.toString()
    }

    @DeleteMapping(path = ["/{id}"])
    fun delete(@PathVariable(value = "id") id: Long): String = "delete item $id"

    @DeleteMapping(path = ["/all"])
    fun delete(): String = "delete item all"
}
