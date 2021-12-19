package com.example.empire.web.ws

import com.example.empire.web.responses.PlanetResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface PlanetWebservice {

    @GET
    fun getPlanet(@Url url: String): Call<PlanetResponse>
}