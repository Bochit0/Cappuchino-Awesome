package org.scesi.cappuchinoawesome.network.data

data class Subject(
    val code: Int,
    val name: String,
    val groups: List<Group>
)