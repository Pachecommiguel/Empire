package com.example.empire.persistence.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.empire.persistence.entities.Character

@TypeConverters(CharacterConverter::class)
@Database(entities = [Character::class], version = 1, exportSchema = false)
abstract class RoomApp : RoomDatabase() {
    abstract fun CharacterDao(): CharacterDao

    companion object {
        const val DATABASE_NAME = "character-db"
    }
}