package com.example.empire.persistence.db

import javax.inject.Inject

class DbManager @Inject constructor(
    private val dao: CharacterDao
) {

}