package com.example.empire.persistence.db

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import com.example.empire.persistence.entities.Film
import com.example.empire.persistence.entities.Planet
import com.example.empire.persistence.entities.Vehicle
import com.google.gson.Gson
import java.io.ByteArrayOutputStream

object CharacterConverter {

    @TypeConverter
    fun fromBitmap(bitmap: Bitmap): ByteArray {
        val outputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        return outputStream.toByteArray()
    }

    @TypeConverter
    fun toBitmap(byteArray: ByteArray): Bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)

    @TypeConverter
    fun toJson(list: ArrayList<Vehicle?>): String = Gson().toJson(list)

    @TypeConverter
    fun fromJsonToList(src: String): ArrayList<Vehicle?> = Gson().fromJson(src, ArrayList<Vehicle?>()::class.java)

    @TypeConverter
    fun toJson(planet: Planet): String = Gson().toJson(planet)

    @TypeConverter
    fun fromJson(src: String): Planet = Gson().fromJson(src, Planet::class.java)

    @TypeConverter
    fun fromFilmToJson(list: ArrayList<Film?>): String = Gson().toJson(list)

    @TypeConverter
    fun fromJsonToListFilm(src: String): ArrayList<Film?> = Gson().fromJson(src, ArrayList<Film?>()::class.java)
}