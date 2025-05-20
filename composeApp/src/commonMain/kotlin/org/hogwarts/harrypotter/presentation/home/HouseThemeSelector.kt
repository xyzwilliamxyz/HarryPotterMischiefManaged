package org.hogwarts.harrypotter.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.hogwarts.harrypotter.presentation.core.theme.House

@Composable
fun HouseThemeSelector(
    selectedHouse: House,
    onSelect: (House) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Select Your House",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )

        House.entries.forEach { house ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = house == selectedHouse,
                        onClick = { onSelect(house) }
                    )
                    .padding(8.dp)
            ) {
                RadioButton(
                    selected = house == selectedHouse,
                    onClick = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = house.name,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}
