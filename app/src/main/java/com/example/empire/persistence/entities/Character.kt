package com.example.empire.persistence.entities

import android.graphics.Bitmap

data class Character(
    var name : String,
    var language: String? = null,
    var avatar: Bitmap? = null
)