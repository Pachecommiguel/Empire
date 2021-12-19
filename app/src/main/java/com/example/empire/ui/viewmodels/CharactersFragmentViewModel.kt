package com.example.empire.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.empire.persistence.CharacterRepository
import com.example.empire.persistence.entities.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersFragmentViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {
    val characterList = repository.characterListLiveData

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCharacters()
        }
    }

    fun onFavoriteClick(checked: Boolean, character: Character) {
        character.isFavorite = checked
        viewModelScope.launch(Dispatchers.IO) {
            when(checked) {
                true -> repository.insert(character)
                false -> repository.remove(character)
            }
        }
    }
}
