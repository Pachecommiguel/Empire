package com.example.empire.persistence

import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import com.example.empire.persistence.entities.Character
import com.example.empire.web.ContentReceiver
import com.example.empire.web.WebManager
import com.example.empire.web.responses.PeopleResponse
import com.example.empire.web.responses.SpeciesResponse
import com.example.empire.web.responses.VehicleResponse
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
            result.species.forEach { webManager.getSpecies(result.name, it) }
            result.vehicles.forEach { webManager.getVehicle(result.name, it) }
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

    override fun onVehicleContent(name: String, body: VehicleResponse?) {
        characterList.find { it.name == name }.let {
            it?.vehicles?.add(body?.name)
        }
    }

    fun getCharacters() {
        webManager.getCharacters()
    }
}