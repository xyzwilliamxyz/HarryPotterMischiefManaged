package org.hogwarts.harrypotter.presentation.list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.hogwarts.harrypotter.core.CoroutineDispatcherProvider
import org.hogwarts.harrypotter.data.repository.HPRepository
import org.hogwarts.harrypotter.domain.model.Character
import org.hogwarts.harrypotter.route.CharactersListType
import org.hogwarts.harrypotter.route.ScreenRoute

class CharactersViewModel(
    private val charactersRepository: HPRepository,
    private val dispatcher: CoroutineDispatcherProvider,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state = MutableStateFlow(CharactersState())
    val state = _state.asStateFlow()

    private val listType: String = savedStateHandle[ScreenRoute.Characters.ARG_CHARACTER_TYPE] ?: ""

    init {
        initialize()
    }

    private fun initialize() {
        _state.value = _state.value.copy(
            screenTitle = listType,
            isLoading = true,
        )

        viewModelScope.launch(dispatcher.io()) {
            runCatching {
                loadCharacters()
            }.onSuccess { characters ->
                _state.value = _state.value.copy(
                    characters = characters,
                    isLoading = false,
                )
            }.onFailure { error ->
                _state.value = _state.value.copy(
                    error = error.message,
                    isLoading = false,
                )
            }
        }
    }

    private suspend fun loadCharacters(): List<Character> {
        return when (listType) {
            CharactersListType.ALL.type -> charactersRepository.getAllCharacters().getOrThrow()
            CharactersListType.STUDENTS.type -> charactersRepository.getStudents().getOrThrow()
            CharactersListType.STAFF.type -> charactersRepository.getStaff().getOrThrow()
            else -> emptyList<Character>()
        }
    }
}

data class CharactersState(
    val screenTitle: String = "",
    val characters: List<Character> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)
