package com.example.empire.persistence.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.empire.persistence.entities.Character

@Dao
interface CharacterDao {
    @Query("SELECT * FROM Character")
    fun getAll(): List<Character>

    @Insert
    fun insert(character: Character)

    @Delete
    fun delete(character: Character)
}