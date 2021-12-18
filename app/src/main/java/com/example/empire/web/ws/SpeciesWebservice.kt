package com.example.empire.web.ws

import com.example.empire.web.responses.SpeciesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface SpeciesWebservice {

    @GET
    fun getSpecies(@Url url: String): Call<SpeciesResponse>
}