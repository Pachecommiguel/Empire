package com.example.empire.persistence.db

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
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
    fun toJson(list: ArrayList<String?>): String = Gson().toJson(list)

    @TypeConverter
    fun fromJsonToList(src: String): ArrayList<String?> = Gson().fromJson(src, ArrayList<String?>()::class.java)
}