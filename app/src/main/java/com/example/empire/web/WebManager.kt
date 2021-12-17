package com.example.empire.web

import android.util.Log
import com.example.empire.web.responses.PeopleResponse
import com.example.empire.web.ws.PeopleWebservice
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class WebManager @Inject constructor(
    private val peopleWebservice: PeopleWebservice
) {

    lateinit var receiver: ContentReceiver

    fun getCharacters() {
        peopleWebservice.getPeople().enqueue(object : Callback<PeopleResponse> {

            override fun onResponse(call: Call<PeopleResponse>, response: Response<PeopleResponse>) {
                receiver.onNewContent(response.body())
            }

            override fun onFailure(call: Call<PeopleResponse>, t: Throwable) {
                Log.e("WebManager", "onFailure" + t.printStackTrace())
            }
        })
    }
}
