package org.hogwarts.harrypotter.presentation.home

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import org.hogwarts.harrypotter.core.CoroutineDispatcherProvider
import org.hogwarts.harrypotter.route.CharactersListType

class HomeViewModel(
    private val dispatcher: CoroutineDispatcherProvider,
) : ViewModel() {
    private val _navigation = MutableSharedFlow<HomeNavigation>()
    val navigation = _navigation.asSharedFlow()

    val actions = HomeActions(
        onClickAllCharacters = ::onClickAllCharacters,
        onClickStudents = ::onClickStudents,
        onClickStaff = ::onClickStaff,
    )

    private fun onClickAllCharacters() {
        viewModelScope.launch(dispatcher.io()) {
            _navigation.emit(HomeNavigation.ToCharacters(CharactersListType.ALL))
        }
    }

    private fun onClickStudents() {
        viewModelScope.launch(dispatcher.io()) {
            _navigation.emit(HomeNavigation.ToCharacters(CharactersListType.STUDENTS))
        }
    }

    private fun onClickStaff() {
        viewModelScope.launch(dispatcher.io()) {
            _navigation.emit(HomeNavigation.ToCharacters(CharactersListType.STAFF))
        }
    }
}

sealed class HomeNavigation {
    data class ToCharacters(val type: CharactersListType) : HomeNavigation()
}

@Immutable
data class HomeActions(
    val onClickAllCharacters: () -> Unit,
    val onClickStudents: () -> Unit,
    val onClickStaff: () -> Unit,
)
