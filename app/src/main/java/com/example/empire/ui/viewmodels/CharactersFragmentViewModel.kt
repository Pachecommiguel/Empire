package com.example.empire.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.empire.persistence.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersFragmentViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    val characterList = repository.characterList

    init {
        repository.getCharacters()
    }
}
