package com.example.empire.persistence.entities

data class Character(
    val id: String,
    val name : String,
    var language: String? = null
)