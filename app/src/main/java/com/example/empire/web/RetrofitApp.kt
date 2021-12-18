package com.example.empire.web

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApp {

    fun getInstance(baseUrl: String): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}