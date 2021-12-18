package com.example.empire.web.responses

import com.google.gson.annotations.SerializedName

data class SpeciesResponse(
    @SerializedName("average_height") val averageHeight : String,
    @SerializedName("skin_colors") val skinColors : String,
    @SerializedName("hair_colors") val hairColors : String,
    @SerializedName("eye_colors") val eyeColors : String,
    @SerializedName("average_lifespan") val averageLifespan : String,
    val name : String,
    val classification : String,
    val designation : String,
    val homeworld : String,
    val language : String,
    val people : List<String>,
    val films : List<String>,
    val created : String,
    val edited : String,
    val url : String
)
