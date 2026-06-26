package org.scesi.cappuchinoawesome.ui.network.data

data class Carreer(val num: Int, val name: String, val level: List<Level>)

data class Level(val code: String, val name:String, val subjects: List<Subject>)

data class Subject(val code: Int, val name: String, val groups: List<Group>)

data class Group(val code: String, val teacher: String, val schedule: List<Slot>)

data class Slot(
    val day: Day,
    val startMin: Int,
    val endMin: Int,
    val room: String,
    val teacher: String,
    val isClass: Boolean
)

enum class Day {
    LU, MA, MI, JU, VI, SA
}