package com.example.empire.persistence

import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import com.example.empire.persistence.db.DbManager
import com.example.empire.persistence.entities.Character
import com.example.empire.persistence.entities.Film
import com.example.empire.persistence.entities.Planet
import com.example.empire.persistence.entities.Vehicle
import com.example.empire.utils.StringUtil
import com.example.empire.web.ContentReceiver
import com.example.empire.web.WebManager
import com.example.empire.web.responses.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepository @Inject constructor(
    private val webManager: WebManager,
    private val dbManager: DbManager,
    private val characterListWeb: MutableLiveData<ArrayList<Character>>,
    val characterListLiveData: MutableLiveData<List<Character>>
) : ContentReceiver {

    private lateinit var characterListDb: List<Character>

    init {
        webManager.receiver = this
    }

    override fun onPeopleContent(body: PeopleResponse?) {
        body?.results?.forEach { result ->
            addCharacter(result)

            when(result.species.isNullOrEmpty()) {
                true -> webManager.getAvatar(result.name, "NA")
                false -> webManager.getSpecies(result.name, result.species[0])
            }

            result.vehicles.forEach { webManager.getVehicle(result.name, it) }
        }

        body?.next?.let { webManager.getCharactersByPage(it) }
    }

    override fun onSpeciesContent(name: String, body: SpeciesResponse?) {
        body?.language?.let { lang ->
            characterListWeb.value?.find { it.name == name }.let { char ->
                char?.language = lang
                webManager.getAvatar(name, StringUtil.getFormattedLanguage(lang))
            }
        }
    }

    override fun onAvatarContent(name: String, bitmap: Bitmap?) {
        characterListWeb.value?.find { it.name == name }.let {
            it?.avatar = bitmap
        }

        if (characterListWeb.value?.last()?.name == name) {
            characterListDb.forEach { char ->
                characterListWeb.value?.find { it.name == char.name }?.isFavorite = char.isFavorite
            }
            characterListLiveData.value = characterListWeb.value
        }
    }

    override fun onVehicleContent(name: String, body: VehicleResponse?) {
        characterListWeb.value?.find { it.name == name }.let {
            it?.vehicles?.add(Vehicle(body?.name))
        }
    }

    override fun onPeopleFailure() {
        characterListLiveData.value = characterListDb
    }

    override fun onPlanetContent(name: String, body: PlanetResponse?) {
        characterListWeb.value?.find { it.name == name }.let {
            it?.homeworld?.name = body?.name
        }
        characterListLiveData.value = characterListWeb.value
    }

    fun getCharacters() {
        characterListDb = dbManager.dao.getAll()
        webManager.getCharacters()
    }

    fun insert(character: Character) {
        dbManager.insert(character)
    }

    fun remove(character: Character) {
        dbManager.delete(character)
    }

    fun getCharacterByName(name: String) : Character? = characterListLiveData.value?.find {
        it.name == name
    }

    private fun addCharacter(result: Results) {
        characterListWeb.value?.add(
            Character(
                name = result.name,
                gender = result.gender,
                skinColor = result.skinColor,
                homeworld = Planet(url = result.homeworld)
            )
        )
    }
}