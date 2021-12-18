package com.example.empire.web.ws

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AvatarWebservice {

    @GET(".")
    fun getAvatar(@Query("name") name: String?): Call<ResponseBody>
}
