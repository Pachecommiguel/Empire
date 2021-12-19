package com.example.empire.web.responses

import com.google.gson.annotations.SerializedName

data class PlanetResponse(
    @SerializedName("rotation_period") val rotationPeriod : Int,
    @SerializedName("orbital_period") val orbitalPeriod : Int,
    @SerializedName("surface_water") val surfaceWater : String,
    val name : String,
    val diameter : Int,
    val climate : String,
    val gravity : String,
    val terrain : String,
    val population : String,
    val residents : List<String>,
    val films : List<String>,
    val created : String,
    val edited : String,
    val url : String
)
