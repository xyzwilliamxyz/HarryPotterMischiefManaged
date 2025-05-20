package org.hogwarts.harrypotter.route

sealed class ScreenRoute(val route: String) {
    data object Home : ScreenRoute("home")
    data object Characters : ScreenRoute("characters/{type}") {
        const val ARG_CHARACTER_TYPE = "type"

        fun routeWithArgs(type: String): String = "characters/$type"
    }
    data object Details : ScreenRoute("details/{characterId}") {
        const val ARG_CHARACTER_ID = "characterId"

        fun routeWithArgs(characterId: Int): String = "details/$characterId"
    }
}

enum class CharactersListType(val type: String) {
    ALL("Characters"),
    STUDENTS("Students"),
    STAFF("Staff"),
    ;

    companion object {
        fun fromString(type: String): CharactersListType {
            return entries.firstOrNull { it.type == type } ?: ALL
        }
    }
}
