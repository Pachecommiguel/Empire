package com.example.empire.persistence

import androidx.lifecycle.MutableLiveData
import com.example.empire.persistence.entities.Character
import com.example.empire.web.ContentReceiver
import com.example.empire.web.WebManager
import com.example.empire.web.responses.PeopleResponse
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

    override fun onNewContent(body: PeopleResponse?) {
        body?.results?.forEach {
            characterList.add(Character(it.name))
        }

        body?.next?.let { webManager.getCharactersByPage(it) } ?: run {
            characterListLiveData.value = characterList
        }
    }

    fun getCharacters() {
        webManager.getCharacters()
    }
}