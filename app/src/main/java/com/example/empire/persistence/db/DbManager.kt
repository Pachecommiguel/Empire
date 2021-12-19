package com.example.empire.persistence.db

import com.example.empire.persistence.entities.Character
import javax.inject.Inject

class DbManager @Inject constructor(
    val dao: CharacterDao
) {
    fun insert(character: Character) {
        dao.insert(character)
    }

    fun delete(character: Character) {
        dao.delete(character)
    }

}