package com.example.empire.web

import android.util.Log
import com.example.empire.web.responses.PeopleResponse
import com.example.empire.web.responses.VehicleResponse
import com.example.empire.web.ws.PeopleWebservice
import com.example.empire.web.ws.VehiclesWebservice
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class WebManager @Inject constructor(
    private val peopleWebservice: PeopleWebservice,
    private val vehiclesWebservice: VehiclesWebservice
) {

    lateinit var receiver: ContentReceiver

    fun getCharacters() {
        peopleWebservice.getPeople().enqueue(object : Callback<PeopleResponse> {

            override fun onResponse(call: Call<PeopleResponse>, response: Response<PeopleResponse>) {
                receiver.onPeopleContent(response.body())
            }

            override fun onFailure(call: Call<PeopleResponse>, t: Throwable) {
                Log.e("WebManager", "onFailure" + t.printStackTrace())
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

    fun getVehicle(url: String) {
        vehiclesWebservice.getVehicle(url).enqueue(object : Callback<VehicleResponse> {
            override fun onResponse(
                call: Call<VehicleResponse>,
                response: Response<VehicleResponse>
            ) {
                receiver.onVehicleContent(response.body())
            }

            override fun onFailure(call: Call<VehicleResponse>, t: Throwable) {
                Log.e("getVehicle", "onFailure" + t.printStackTrace())
            }
        })
    }
}
