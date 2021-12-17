package com.example.empire.ui.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.empire.persistence.entities.Character

class CharacterDiffCallback : DiffUtil.ItemCallback<Character>() {

    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean =
        oldItem == newItem

}
