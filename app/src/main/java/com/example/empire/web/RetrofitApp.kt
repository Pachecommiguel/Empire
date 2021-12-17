package com.example.empire.web

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApp {

    fun getInstance(): Retrofit = Retrofit.Builder()
        .baseUrl("https://swapi.py4e.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}