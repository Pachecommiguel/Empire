package com.example.empire.web.ws

import com.example.empire.web.responses.PeopleResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface PeopleWebservice {

    @GET("people")
    fun getPeople(): Call<PeopleResponse>

    @GET
    fun getPeopleByPage(@Url url: String): Call<PeopleResponse>
}