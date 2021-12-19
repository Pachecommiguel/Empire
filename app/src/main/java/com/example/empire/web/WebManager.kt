package com.example.empire.web

import android.graphics.BitmapFactory
import android.util.Log
import com.example.empire.web.responses.PeopleResponse
import com.example.empire.web.responses.PlanetResponse
import com.example.empire.web.responses.SpeciesResponse
import com.example.empire.web.responses.VehicleResponse
import com.example.empire.web.ws.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class WebManager @Inject constructor(
    private val peopleWebservice: PeopleWebservice,
    private val speciesWebservice: SpeciesWebservice,
    private val avatarWebservice: AvatarWebservice,
    private val vehicleWebservice: VehicleWebservice,
    private val planetWebservice: PlanetWebservice
) {

    lateinit var receiver: ContentReceiver

    fun getCharacters() {
        peopleWebservice.getPeople().enqueue(object : Callback<PeopleResponse> {
            override fun onResponse(
                call: Call<PeopleResponse>,
                response: Response<PeopleResponse>
            ) {
                receiver.onPeopleContent(response.body())
            }

            override fun onFailure(call: Call<PeopleResponse>, t: Throwable) {
                receiver.onPeopleFailure()
                Log.e("getPeople", "onFailure" + t.printStackTrace())
            }
        })
    }

    fun getCharactersByPage(url: String) {
        peopleWebservice.getPeopleByPage(url).enqueue(object : Callback<PeopleResponse> {
            override fun onResponse(
                call: Call<PeopleResponse>,
                response: Response<PeopleResponse>
            ) {
                receiver.onPeopleContent(response.body())
            }

            override fun onFailure(call: Call<PeopleResponse>, t: Throwable) {
                Log.e("getPeopleByPage", "onFailure" + t.printStackTrace())
            }
        })
    }

    fun getSpecies(name: String, url: String) {
        speciesWebservice.getSpecies(url).enqueue(object : Callback<SpeciesResponse> {
            override fun onResponse(
                call: Call<SpeciesResponse>,
                response: Response<SpeciesResponse>
            ) {
                receiver.onSpeciesContent(name, response.body())
            }

            override fun onFailure(call: Call<SpeciesResponse>, t: Throwable) {
                Log.e("getSpecies", "onFailure" + t.printStackTrace())
            }
        })
    }

    fun getAvatar(name: String, language: String?) {
        avatarWebservice.getAvatar(language).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                receiver.onAvatarContent(name, BitmapFactory.decodeStream(response.body()?.byteStream()))
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.e("getAvatar", "onFailure" + t.printStackTrace())
            }
        })
    }

    fun getVehicle(name: String, url: String) {
        vehicleWebservice.getVehicle(url).enqueue(object : Callback<VehicleResponse> {
            override fun onResponse(
                call: Call<VehicleResponse>,
                response: Response<VehicleResponse>
            ) {
                receiver.onVehicleContent(name, response.body())
            }

            override fun onFailure(call: Call<VehicleResponse>, t: Throwable) {
                Log.e("getVehicle", "onFailure" + t.printStackTrace())
            }
        })
    }

    fun getPlanet(name: String, url: String) {
        planetWebservice.getPlanet(url).enqueue(object : Callback<PlanetResponse> {
            override fun onResponse(
                call: Call<PlanetResponse>,
                response: Response<PlanetResponse>
            ) {
                receiver.onPlanetContent(name, response.body())
            }

            override fun onFailure(call: Call<PlanetResponse>, t: Throwable) {
                Log.e("getPlanet", "onFailure" + t.printStackTrace())
            }
        })
    }
}
