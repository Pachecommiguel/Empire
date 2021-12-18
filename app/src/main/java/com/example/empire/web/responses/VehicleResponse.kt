package com.example.empire.web.responses

import com.google.gson.annotations.SerializedName

data class VehicleResponse(
    @SerializedName("cost_in_credits") val cost_in_credits : String,
    @SerializedName("max_atmosphering_speed") val max_atmosphering_speed : String,
    @SerializedName("cargo_capacity") val cargo_capacity : String,
    @SerializedName("vehicle_class") val vehicle_class : String,
    val name : String,
    val model : String,
    val manufacturer : String,
    val length : String,
    val crew : String,
    val passengers : String,
    val consumables : String,
    val pilots : List<String>,
    val films : List<String>,
    val created : String,
    val edited : String,
    val url : String
)
