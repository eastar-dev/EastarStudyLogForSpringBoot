package dev.eastar.studylog.notification

data class PushItem(
    var to: MutableSet<String> = mutableSetOf(),
    var title: String,
    var content: String
)
