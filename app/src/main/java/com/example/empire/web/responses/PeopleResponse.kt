package com.example.empire.web.responses

data class PeopleResponse (

    val count : Int,
    val next : String,
    val previous : String,
    val results : List<Results>
)
