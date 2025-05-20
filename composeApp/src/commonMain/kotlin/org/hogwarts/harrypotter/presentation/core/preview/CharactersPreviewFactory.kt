package org.hogwarts.harrypotter.presentation.core.preview

import org.hogwarts.harrypotter.domain.model.Character
import org.hogwarts.harrypotter.domain.model.Wand

object CharactersPreviewFactory {
    fun sample() = listOf(
        Character(
            id = "1",
            name = "Harry Potter",
            house = "Gryffindor",
            patronus = "Stag",
            image = "https://ik.imagekit.io/hpapi/harry.jpg",
            species = "Human",
            ancestry = "Half-blood",
            wand = Wand("Holly", "Phoenix feather", 11.0),
        ),
        Character(
            id = "2",
            name = "Hermione Granger",
            house = "Gryffindor",
            patronus = "Otter",
            image = "https://ik.imagekit.io/hpapi/hermione.jpeg",
            species = "Human",
            ancestry = "Muggle-born",
            wand = Wand("Vine", "Dragon heartstring", 10.75),
        ),
        Character(
            id = "3",
            name = "Draco Malfoy",
            house = "Slytherin",
            patronus = "",
            image = "https://ik.imagekit.io/hpapi/draco.jpg",
            species = "Human",
            ancestry = "Pure-blood",
            wand = Wand("Hawthorn", "Unicorn hair", 10.0),
        ),
    )
}
