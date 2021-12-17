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

    val characterList = MutableLiveData<List<Character>>()

    init {
        webManager.receiver = this
    }

    override fun onNewContent(body: PeopleResponse?) {
        characterList.value = body?.results?.map {
            Character(it.name)
        }

        //body?.next?.let { webManager.getCharactersByPage(it) } todo
    }

    fun getCharacters() {
        webManager.getCharacters()
    }
}