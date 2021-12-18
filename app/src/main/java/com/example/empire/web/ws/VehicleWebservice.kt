package com.example.empire.web.ws

import com.example.empire.web.responses.VehicleResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface VehicleWebservice {

    @GET
    fun getVehicle(@Url url: String): Call<VehicleResponse>
}