package dev.eastar.studylog.item

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/item")
class ContentController {
    @Autowired
    lateinit var repository: StudyItemRepository

    @RequestMapping(method = [RequestMethod.GET, RequestMethod.POST], path = ["/{id}"])
    fun post(@PathVariable(value = "id") id: String) = repository.findById(id)

    @RequestMapping(method = [RequestMethod.GET, RequestMethod.POST])
    fun post() = repository.findAll(Sort.by(Sort.Direction.DESC, "millisecond"))

    @PutMapping(consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE])
    @ResponseBody
    fun insert(studyItem: StudyItem) = repository.insert(studyItem)

    @PostMapping(consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE])
    @ResponseBody
    fun update(studyItem: StudyItem) = repository.save(studyItem)

    @DeleteMapping(path = ["/{id}"])
    fun delete(@PathVariable(value = "id") id: String) = repository.deleteById(id)

    @DeleteMapping(path = ["/all"])
    fun delete() = repository.deleteAll()
}
