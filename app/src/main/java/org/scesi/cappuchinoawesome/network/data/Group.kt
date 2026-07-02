package org.scesi.cappuchinoawesome.network.data

data class Group(
    val code: String,
    val teacher: String,
    val schedule: List<Slot>
)