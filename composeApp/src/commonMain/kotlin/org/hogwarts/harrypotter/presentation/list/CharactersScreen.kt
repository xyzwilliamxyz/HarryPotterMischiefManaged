package org.hogwarts.harrypotter.presentation.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.hogwarts.harrypotter.domain.model.Character
import org.hogwarts.harrypotter.presentation.core.component.HPMMTopBar
import org.hogwarts.harrypotter.presentation.core.component.LoadingIndicator
import org.hogwarts.harrypotter.presentation.core.preview.CharactersPreviewFactory
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CharactersScreen(
    viewModel: CharactersViewModel = koinViewModel(),
    onBackClick: () -> Unit = {},
) {
    val state = viewModel.state.collectAsState().value

    CharactersScreenInternal(
        state = state,
        onBackClick = onBackClick,
    )
}

@Composable
private fun CharactersScreenInternal(
    modifier: Modifier = Modifier,
    state: CharactersState,
    onBackClick: () -> Unit = {},
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            HPMMTopBar(
                title = state.screenTitle,
                onBackClick = onBackClick,
            )
        },
    ) { innerPadding ->
        Surface {
            if (state.isLoading) {
                LoadingIndicator()
            } else {
                LazyColumn(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(state.characters.size) { index ->
                        CharacterCard(character = state.characters[index])
                    }
                }
            }
        }
    }
}

@Composable
private fun CharacterCard(character: Character) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(70.dp)
                    .padding(end = 16.dp),
                model = character.image,
                contentDescription = null,
                placeholder = null,
                error = null
            )

            Column {
                Text(
                    text = character.name,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = character.house,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.75f)
                )
            }

            Spacer(modifier = Modifier.weight(1f))
            Image(
                modifier = Modifier.size(32.dp),
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = null,
                alpha = 0.3f
            )
        }
    }
}

@Preview
@Composable
private fun CharactersScreen_Preview() {
    MaterialTheme {
        CharactersScreenInternal(
            state = CharactersState(
                screenTitle = "Characters",
                characters = CharactersPreviewFactory.sample()
            )
        )
    }
}
