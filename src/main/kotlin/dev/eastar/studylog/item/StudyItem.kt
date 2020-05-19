package dev.eastar.studylog.item

data class StudyItem(var title: String, var content: String) {
    private lateinit var _id: String
    override fun toString(): String {
        return "$_id : $title : $content"
    }
}





