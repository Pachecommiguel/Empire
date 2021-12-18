package com.example.empire.persistence

import android.graphics.Bitmap
import android.util.Log
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
            result.species.let {
                if (it.isNotEmpty()) {
                    webManager.getSpecies(result.name, it[0])
                }
            }
            characterList.add(Character(result.name))
        }

        body?.next?.let { webManager.getCharactersByPage(it) }
    }

    override fun onSpeciesContent(name: String, body: SpeciesResponse?) {
        characterList.find { it.name == name }.let {
            it?.language = body?.language
            webManager.getAvatar(name, it?.language)
        }
    }

    override fun onAvatarContent(name: String, bitmap: Bitmap?) {
        characterList.find { it.name == name }.let {
            it?.avatar = bitmap
        }

        if (characterList.last().name == name) {
            characterListLiveData.value = characterList
        }
    }

    fun getCharacters() {
        webManager.getCharacters()
    }
}