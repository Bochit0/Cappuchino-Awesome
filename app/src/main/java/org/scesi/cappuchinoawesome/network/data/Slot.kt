package org.scesi.cappuchinoawesome.network.data

data class Slot(
    val day: Day,
    val start: String,
    val end: String,
    val room: String,
    val teacher: String,
    val isClass: Boolean
)

enum class Day {
    LU, MA, MI, JU, VI, SA
}