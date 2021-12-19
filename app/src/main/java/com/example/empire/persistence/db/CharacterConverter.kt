package com.example.empire.persistence.db

import android.graphics.Bitmap
import androidx.room.TypeConverter
import com.google.gson.Gson

object CharacterConverter {

    @TypeConverter
    fun toJson(bitmap: Bitmap): String = Gson().toJson(bitmap)

    @TypeConverter
    fun fromJsonToBitmap(src: String): Bitmap = Gson().fromJson(src, Bitmap::class.java)

    @TypeConverter
    fun toJson(list: ArrayList<String?>): String = Gson().toJson(list)

    @TypeConverter
    fun fromJsonToList(src: String): ArrayList<String?> = Gson().fromJson(src, ArrayList<String?>()::class.java)
}