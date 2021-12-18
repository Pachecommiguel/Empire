package com.example.empire.web

import android.graphics.Bitmap
import com.example.empire.web.responses.PeopleResponse
import com.example.empire.web.responses.SpeciesResponse

interface ContentReceiver {
    fun onPeopleContent(body: PeopleResponse?)
    fun onSpeciesContent(name: String, body: SpeciesResponse?)
    fun onAvatarContent(name: String, bitmap: Bitmap?)
}