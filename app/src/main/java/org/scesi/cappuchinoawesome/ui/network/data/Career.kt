package org.scesi.cappuchinoawesome.ui.network.data

data class Career(val code: Int, val name: String, val pdfUrl: String, val semester: String)

data class DetailCareer(val code: Int, val name: String, val levels: List<Level> )
data class Level(val code: String, val name:String, val subjects: List<Subject>)

data class Subject(val code: Int, val name: String, val groups: List<Group>)

data class Group(val code: String, val teacher: String, val schedule: List<Slot>)

data class Slot(
    val day: Day,
    val start: String,
    val end: String,
    val room: String,
    val teacher: String,
    val isClass: Boolean
)

data class GroupSubject(val group: Group, val subjectName: String)
enum class Day {
    LU, MA, MI, JU, VI, SA
}