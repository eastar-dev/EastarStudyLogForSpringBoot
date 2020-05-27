@file:Suppress("unused")

package dev.eastar.studylog.item

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/item")
class ContentController {
    @Autowired
    lateinit var repository: StudyItemRepository

    companion object {
        val SORT = Sort.by(Sort.Direction.DESC, "millisecond")
    }

    @PostMapping(path = ["/test"])
    fun test(@RequestParam(value = "id", defaultValue = "${Int.MAX_VALUE}", required = false) id: Int,
             @RequestParam("size", defaultValue = "30", required = false) size: Int): MutableList<StudyItem> {
        println("===================================test===================================")
        //return repository.findByPushIs(0L)
        return repository.findByTestLessThan(id, PageRequest.of(0, size, SORT)).content
    }

    //id 기반 호출
    @PostMapping
    fun last(@RequestParam(value = "millisecond", defaultValue = "${Long.MAX_VALUE}", required = false) id: Long,
             @RequestParam("size", defaultValue = "30", required = false) size: Int): MutableList<StudyItem> {
        return repository.findByMillisecondLessThan(id, PageRequest.of(0, size, SORT)).content
    }

    @PutMapping(consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE])
    fun updateOrInsert(studyItem: StudyItem) = repository.save(studyItem)

    @PostMapping(path = ["/{id}"])
    fun selectById(@PathVariable(value = "id") id: String) = repository.findById(id)

    @DeleteMapping(path = ["/{id}"])
    fun deleteById(@PathVariable(value = "id") id: String) = repository.deleteById(id)

    @RequestMapping(path = ["/all"])
    fun selectAll(): MutableList<StudyItem> = repository.findAll(SORT)

    @DeleteMapping(path = ["/all"])
    fun delete() = repository.deleteAll()


    ////page 기반 호출
    //@PostMapping
    //fun page(@RequestParam("page", defaultValue = "0", required = false) page: Int,
    //         @RequestParam("size", defaultValue = "30", required = false) size: Int): MutableList<StudyItem> {
    //    return repository.findAll(PageRequest.of(page, size, SORT)).content
    //}

}
