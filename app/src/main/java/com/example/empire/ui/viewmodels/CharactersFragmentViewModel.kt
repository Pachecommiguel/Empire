package com.example.empire.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.empire.persistence.entities.Character

class CharactersFragmentViewModel : ViewModel() {

    val characterList = MutableLiveData<List<Character>>()

}
