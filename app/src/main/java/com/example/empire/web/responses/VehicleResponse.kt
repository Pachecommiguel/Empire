package com.example.empire.web.responses

import com.google.gson.annotations.SerializedName

data class VehicleResponse (
    @SerializedName("cargo_capacity") val cargoCapacity : String,
    @SerializedName("vehicle_class") val vehicleClass : String,
    @SerializedName("cost_in_credits") val costInCredits : String,
    @SerializedName("max_atmosphering_speed") val maxAtmospheringSpeed : String,
    val consumables : String,
    val created : String,
    val crew : String,
    val edited : String,
    val length : String,
    val manufacturer : String,
    val model : String,
    val name : String,
    val passengers : String,
    val pilots : List<String>,
    val films : List<String>,
    val url : String
)