package org.hogwarts.harrypotter.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(

    @SerialName("patronus")
    val patronus: String? = null,

    @SerialName("hogwartsStudent")
    val hogwartsStudent: Boolean? = null,

    @SerialName("image")
    val image: String? = null,

    @SerialName("ancestry")
    val ancestry: String? = null,

    @SerialName("gender")
    val gender: String? = null,

    @SerialName("alive")
    val alive: Boolean? = null,

    @SerialName("hairColour")
    val hairColour: String? = null,

    @SerialName("dateOfBirth")
    val dateOfBirth: String? = null,

    @SerialName("house")
    val house: String? = null,

    @SerialName("hogwartsStaff")
    val hogwartsStaff: Boolean? = null,

    @SerialName("alternate_names")
    val alternateNames: List<String?>? = null,

    @SerialName("actor")
    val actor: String? = null,

    @SerialName("species")
    val species: String? = null,

    @SerialName("wand")
    val wand: WandResponse? = null,

    @SerialName("name")
    val name: String? = null,

    @SerialName("wizard")
    val wizard: Boolean? = null,

    @SerialName("eyeColour")
    val eyeColour: String? = null,

    @SerialName("id")
    val id: String? = null,

    @SerialName("yearOfBirth")
    val yearOfBirth: Int? = null,
) {
    @Serializable
    data class WandResponse(

        @SerialName("core")
        val core: String? = null,

        @SerialName("length")
        val length: Double? = null,

        @SerialName("wood")
        val wood: String? = null,
    )
}
