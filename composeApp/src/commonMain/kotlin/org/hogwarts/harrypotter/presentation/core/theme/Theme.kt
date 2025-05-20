package org.hogwarts.harrypotter.presentation.core.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.ui.graphics.Color

enum class House {
    Gryffindor,
    Slytherin,
    Hufflepuff,
    Ravenclaw,
}

val GryffindorScheme = darkColorScheme(
    primary = Color(0xFF7F0909),
    secondary = Color(0xFFD3A625),
    background = Color(0xFF2E2E2E),
)

val SlytherinScheme = darkColorScheme(
    primary = Color(0xFF1A472A),
    secondary = Color(0xFFAAAAAA),
    background = Color(0xFF1E1E1E),
)

val HufflepuffScheme = darkColorScheme(
    primary = Color(0xFFB38F00),
    secondary = Color(0xFF000000),
    background = Color(0xFFB38F00),
)

val RavenclawScheme = darkColorScheme(
    primary = Color(0xFF0E1A40),
    secondary = Color(0xFF946B2D),
    background = Color(0xFF1A1A1A),
)

// Mapping
fun getColorScheme(house: House): ColorScheme = when (house) {
    House.Gryffindor -> GryffindorScheme
    House.Slytherin -> SlytherinScheme
    House.Hufflepuff -> HufflepuffScheme
    House.Ravenclaw -> RavenclawScheme
}
