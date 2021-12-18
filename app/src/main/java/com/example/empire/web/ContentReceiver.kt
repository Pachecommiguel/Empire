package com.example.empire.web

import com.example.empire.web.responses.PeopleResponse
import com.example.empire.web.responses.VehicleResponse

interface ContentReceiver {
    fun onPeopleContent(body: PeopleResponse?)
    fun onVehicleContent(body: VehicleResponse?)
}