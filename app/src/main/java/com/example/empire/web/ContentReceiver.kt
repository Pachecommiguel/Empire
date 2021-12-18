package com.example.empire.web

import com.example.empire.web.responses.PeopleResponse
import com.example.empire.web.responses.SpeciesResponse

interface ContentReceiver {
    fun onPeopleContent(body: PeopleResponse?)
    fun onSpeciesContent(body: SpeciesResponse?)
}