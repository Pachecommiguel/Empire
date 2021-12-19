package com.example.empire.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.empire.persistence.CharacterRepository
import com.example.empire.persistence.entities.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsFragmentViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    var character: Character? = null

    fun onCharacterName(name: String?) {
        name?.let { character = repository.getCharacterByName(it) }
    }
}