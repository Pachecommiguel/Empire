package com.example.empire.persistence

import androidx.lifecycle.MutableLiveData
import com.example.empire.persistence.entities.Character
import com.example.empire.web.ContentReceiver
import com.example.empire.web.WebManager
import com.example.empire.web.responses.PeopleResponse
import com.example.empire.web.responses.SpeciesResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepository @Inject constructor(
    private val webManager: WebManager
) : ContentReceiver {

    val characterListLiveData = MutableLiveData<List<Character>>()
    private val characterList = ArrayList<Character>()

    init {
        webManager.receiver = this
    }

    override fun onPeopleContent(body: PeopleResponse?) {
        body?.results?.forEach { result ->
            characterList.add(Character(result.name))
            webManager.getSpecies(result.species[0])
        }

        body?.next?.let { webManager.getCharactersByPage(it) } ?: run {
            characterListLiveData.value = characterList
        }
    }

    override fun onSpeciesContent(body: SpeciesResponse?) {
        TODO("Not yet implemented")
    }

    fun getCharacters() {
        webManager.getCharacters()
    }
}