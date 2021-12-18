package com.example.empire.ui.recycler

import androidx.recyclerview.widget.RecyclerView
import com.example.empire.databinding.CharacterRecyclerViewItemBinding
import com.example.empire.persistence.entities.Character

class CharacterViewHolder(
    val binding: CharacterRecyclerViewItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(character: Character) {
        binding.character = character
    }
}
