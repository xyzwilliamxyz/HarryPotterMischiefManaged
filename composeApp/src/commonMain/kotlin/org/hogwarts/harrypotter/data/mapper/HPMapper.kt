package org.hogwarts.harrypotter.data.mapper

import org.hogwarts.harrypotter.data.remote.response.CharacterResponse
import org.hogwarts.harrypotter.domain.model.Character
import org.hogwarts.harrypotter.domain.model.Wand

class HPMapper {
    fun toDomain(response: List<CharacterResponse>): List<Character> {
        return response.map {
            Character(
                id = it.id.orEmpty(),
                name = it.name.orEmpty(),
                house = it.house.orEmpty().ifBlank { "N/A" },
                patronus = it.patronus.orEmpty(),
                image = it.image.orEmpty(),
                species = it.species.orEmpty(),
                ancestry = it.ancestry.orEmpty(),
                wand = it.wand?.let { wand ->
                    Wand(
                        wood = wand.wood.orEmpty(),
                        core = wand.core.orEmpty(),
                        length = wand.length ?: 0.0,
                    )
                } ?: Wand(
                    wood = "",
                    core = "",
                    length = 0.0,
                ),
            )
        }
    }
}
