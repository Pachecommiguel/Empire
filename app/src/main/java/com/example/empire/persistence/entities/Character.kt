package com.example.empire.persistence.entities

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.empire.persistence.db.CharacterConverter

@Entity
data class Character(
    @PrimaryKey
    var name : String,
    var language: String? = null,
    var avatar: Bitmap? = null,
    var vehicles: ArrayList<String?> = arrayListOf()
)