package org.hogwarts.harrypotter.domain.model

data class Character(
    val id: String,
    val name: String,
    val house: String,
    val patronus: String,
    val image: String,
    val species: String,
    val ancestry: String,
    val wand: Wand,
)
