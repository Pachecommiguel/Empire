package com.example.empire.web.ws

import com.example.empire.web.responses.PeopleResponse
import retrofit2.Call
import retrofit2.http.GET

interface PeopleWebservice {

    @GET("people")
    fun getPeople(): Call<PeopleResponse>
}