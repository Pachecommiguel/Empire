package com.example.empire.web

import android.util.Log
import com.example.empire.web.responses.PeopleResponse
import com.example.empire.web.responses.SpeciesResponse
import com.example.empire.web.ws.PeopleWebservice
import com.example.empire.web.ws.SpeciesWebservice
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class WebManager @Inject constructor(
    private val peopleWebservice: PeopleWebservice,
    private val speciesWebservice: SpeciesWebservice
) {

    lateinit var receiver: ContentReceiver

    fun getCharacters() {
        peopleWebservice.getPeople().enqueue(object : Callback<PeopleResponse> {

            override fun onResponse(call: Call<PeopleResponse>, response: Response<PeopleResponse>) {
                receiver.onPeopleContent(response.body())
            }

            override fun onFailure(call: Call<PeopleResponse>, t: Throwable) {
                Log.e("getPeople", "onFailure" + t.printStackTrace())
            }
        })
    }

    fun getCharactersByPage(url: String) {
        peopleWebservice.getPeopleByPage(url).enqueue(object : Callback<PeopleResponse> {
            override fun onResponse(call: Call<PeopleResponse>, response: Response<PeopleResponse>) {
                receiver.onPeopleContent(response.body())
            }

            override fun onFailure(call: Call<PeopleResponse>, t: Throwable) {
                Log.e("getPeopleByPage", "onFailure" + t.printStackTrace())
            }
        })
    }

    fun getSpecies(url: String) {
        speciesWebservice.getSpecies(url).enqueue(object : Callback<SpeciesResponse> {
            override fun onResponse(
                call: Call<SpeciesResponse>,
                response: Response<SpeciesResponse>
            ) {
                receiver.onSpeciesContent(response.body())
            }

            override fun onFailure(call: Call<SpeciesResponse>, t: Throwable) {
                Log.e("getSpecies", "onFailure" + t.printStackTrace())
            }

        })
    }
}
