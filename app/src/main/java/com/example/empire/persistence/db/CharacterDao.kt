package com.example.empire.persistence.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.empire.persistence.entities.Character

@Dao
interface CharacterDao {
    @Query("SELECT * FROM Character")
    fun getAll(): LiveData<List<Character>>
}