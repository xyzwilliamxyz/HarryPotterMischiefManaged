package org.hogwarts.harrypotter

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.hogwarts.harrypotter.presentation.core.theme.House
import org.hogwarts.harrypotter.presentation.core.theme.getColorScheme
import org.hogwarts.harrypotter.presentation.home.HomeScreen
import org.hogwarts.harrypotter.presentation.list.CharactersScreen
import org.hogwarts.harrypotter.route.ScreenRoute
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun App() {
    var selectedHouse by remember { mutableStateOf(House.Gryffindor) }
    val colorScheme = getColorScheme(selectedHouse)
    val navController = rememberNavController()

    MaterialTheme(colorScheme = colorScheme) {
        NavHost(navController, startDestination = ScreenRoute.Home.route) {
            composable(ScreenRoute.Home.route) {
                HomeScreen(
                    selectedHouse = selectedHouse,
                    onSelect = { house ->
                        selectedHouse = house
                    },
                    onNavigation = { dest ->
                        val route = ScreenRoute.Characters.routeWithArgs(dest.type)
                        navController.navigate(route)
                    },
                )
            }

            composable(
                route = ScreenRoute.Characters.route,
                arguments = listOf(navArgument(ScreenRoute.Characters.ARG_CHARACTER_TYPE) { type = NavType.StringType }),
            ) {
                CharactersScreen(
                    onBackClick = { navController.popBackStack() },
                )
            }
        }
    }
}
