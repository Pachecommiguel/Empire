package com.example.empire.persistence.entities

data class Character(
    val url: String,
    val name : String,
    val vehicles : ArrayList<Vehicle> = arrayListOf(),
)