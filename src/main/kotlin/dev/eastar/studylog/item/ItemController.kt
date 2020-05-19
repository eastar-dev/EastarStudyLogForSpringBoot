package dev.eastar.studylog.item

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/item")
class ContentController {

    @Autowired
    lateinit var mongoTemplate: MongoTemplate

    @RequestMapping(method = [RequestMethod.GET, RequestMethod.POST], path = ["/{id}"])
    fun post(@PathVariable(value = "id") id: Long): String = "post item $id"

    @RequestMapping(method = [RequestMethod.GET, RequestMethod.POST])
    fun post(): String = "post items"

    @PutMapping()
    fun put(@RequestBody param: Map<String, Any>): String {
        return "put item $param"
    }

    @DeleteMapping(path = ["/{id}"])
    fun delete(@PathVariable(value = "id") id: Long): String = "delete item $id"

    @DeleteMapping(path = ["/all"])
    fun delete(): String = "delete item all"
}
