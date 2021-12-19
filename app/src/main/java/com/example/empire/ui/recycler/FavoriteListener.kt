package com.example.empire.ui.recycler

import com.example.empire.persistence.entities.Character

interface FavoriteListener {
    fun onFavoriteClick(checked: Boolean, character: Character)
}
