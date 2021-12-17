package com.example.empire.web

import com.example.empire.web.responses.PeopleResponse

interface ContentReceiver {
    fun onNewContent(body: PeopleResponse?)
}