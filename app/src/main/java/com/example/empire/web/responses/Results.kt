package com.example.empire.web.responses

import com.google.gson.annotations.SerializedName

data class Results (
    @SerializedName("hair_color") val hairColor : String,
    @SerializedName("skin_color") val skinColor : String,
    @SerializedName("eye_color") val eyeColor : String,
    @SerializedName("birth_year") val birthYear : String,
    val name : String,
    val height : String,
    val mass : String,
    val gender : String,
    val homeworld : String,
    val films : List<String>,
    val species : List<String>,
    val vehicles : List<String>,
    val starships : List<String>,
    val created : String,
    val edited : String,
    val url : String
)