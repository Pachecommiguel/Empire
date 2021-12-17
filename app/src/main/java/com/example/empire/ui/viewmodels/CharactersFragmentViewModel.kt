package com.example.empire.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.empire.persistence.entities.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersFragmentViewModel @Inject constructor(

) : ViewModel() {

    val characterList = MutableLiveData<List<Character>>()

}
