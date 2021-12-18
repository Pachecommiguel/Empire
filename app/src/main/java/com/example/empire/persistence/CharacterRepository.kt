package com.example.empire.persistence

import androidx.lifecycle.MutableLiveData
import com.example.empire.persistence.entities.Character
import com.example.empire.persistence.entities.Vehicle
import com.example.empire.web.ContentReceiver
import com.example.empire.web.WebManager
import com.example.empire.web.responses.PeopleResponse
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
            result.vehicles.forEach { webManager.getVehicle(it) }
            characterList.add(Character(result.url, result.name))
        }

        body?.next?.let { webManager.getCharactersByPage(it) } ?: run {
            characterListLiveData.value = characterList
        }
    }

    override fun onVehicleContent(body: VehicleResponse?) {
        body?.pilots?.forEach { pilot ->
            characterList.find { it.url == pilot }?.vehicles?.add(Vehicle(body.name))
        }
    }

    fun getCharacters() {
        webManager.getCharacters()
    }
}