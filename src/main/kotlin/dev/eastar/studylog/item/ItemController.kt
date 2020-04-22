package dev.eastar.studylog.item

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/item")
class ContentController {

    @Autowired
    lateinit var mongoTemplate: MongoTemplate

    @GetMapping()
    @PostMapping()
    fun post(): String = "post item"

    @PutMapping()
    fun put(@RequestBody param: Map<String, Any>): String {
        return "put item $param"
    }

    @DeleteMapping()
    fun delete(): String = "delete item"
}
