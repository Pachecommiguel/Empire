package com.example.empire.persistence.entities

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Character(
    @PrimaryKey
    var name : String,
    var language: String? = null,
    var avatar: Bitmap? = null,
    var vehicles: ArrayList<Vehicle> = arrayListOf(),
    var isFavorite: Boolean = false,
    var gender: String,
    var skinColor: String,
    var homeworld: Planet?,
    var movies: ArrayList<Film> = arrayListOf()
)