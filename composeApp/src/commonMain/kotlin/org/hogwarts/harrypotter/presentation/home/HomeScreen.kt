package org.hogwarts.harrypotter.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import org.hogwarts.harrypotter.presentation.core.component.HPMMTopBar
import org.hogwarts.harrypotter.presentation.core.theme.House
import org.hogwarts.harrypotter.route.CharactersListType
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel(),
    selectedHouse: House,
    onSelect: (House) -> Unit,
    onNavigation: (CharactersListType) -> Unit,
) {
    val actions = viewModel.actions

    HandleNavigation(
        navigationFlow = viewModel.navigation,
        onNavigation = { route ->
            onNavigation(route)
        }
    )

    HomeScreenInternal(
        modifier = modifier,
        selectedHouse = selectedHouse,
        onSelect = onSelect,
        actions = actions
    )
}

@Composable
private fun HandleNavigation(
    navigationFlow: Flow<HomeNavigation>,
    onNavigation: (CharactersListType) -> Unit,
) {
    val currentOnClick by rememberUpdatedState(onNavigation)

    LaunchedEffect(Unit) {
        navigationFlow.collectLatest {
            when (it) {
                is HomeNavigation.ToCharacters -> {
                    currentOnClick(it.type)
                }
            }
        }
    }
}

@Composable
private fun HomeScreenInternal(
    modifier: Modifier = Modifier,
    selectedHouse: House,
    onSelect: (House) -> Unit,
    actions: HomeActions
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            HPMMTopBar(
                title = "Home",
            )
        },
    ) { innerPadding ->
        Surface {
            Column(Modifier.fillMaxWidth()) {
                CategoryCards(
                    modifier = Modifier.padding(innerPadding),
                    actions = actions,
                )
                Spacer(modifier = Modifier.weight(1f))
                HouseThemeSelector(
                    selectedHouse = selectedHouse,
                    onSelect = onSelect,
                )
            }
        }
    }
}

@Composable
fun CategoryCards(
    modifier: Modifier = Modifier,
    actions: HomeActions,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 32.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CategoryCard(
            category = "All Characters",
            onCategoryClick = actions.onClickAllCharacters
        )
        CategoryCard(
            category = "Students",
            onCategoryClick = actions.onClickStudents
        )
        CategoryCard(
            category = "Staff",
            onCategoryClick = actions.onClickStaff
        )
    }
}

@Composable
private fun CategoryCard(
    category: String,
    onCategoryClick: () -> Unit
) {
    Card(
        onClick = onCategoryClick,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = category,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Preview
@Composable
private fun HomeScreen_Preview() {
    MaterialTheme {
        HomeScreen(
            selectedHouse = House.Gryffindor,
            onSelect = {},
            onNavigation = {},
        )
    }
}
