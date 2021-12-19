package com.example.empire.web

import android.graphics.Bitmap
import com.example.empire.web.responses.PeopleResponse
import com.example.empire.web.responses.PlanetResponse
import com.example.empire.web.responses.SpeciesResponse
import com.example.empire.web.responses.VehicleResponse

interface ContentReceiver {
    fun onPeopleContent(body: PeopleResponse?)
    fun onSpeciesContent(name: String, body: SpeciesResponse?)
    fun onAvatarContent(name: String, bitmap: Bitmap?)
    fun onVehicleContent(name: String, body: VehicleResponse?)
    fun onPeopleFailure()
    fun onPlanetContent(name: String, body: PlanetResponse?)
}