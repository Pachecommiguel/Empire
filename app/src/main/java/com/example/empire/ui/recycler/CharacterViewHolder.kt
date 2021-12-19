package com.example.empire.ui.recycler

import androidx.recyclerview.widget.RecyclerView
import com.example.empire.databinding.CharacterRecyclerViewItemBinding
import com.example.empire.persistence.entities.Character

class CharacterViewHolder(
    private val binding: CharacterRecyclerViewItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(character: Character, listener: FavoriteListener) {
        binding.character = character
        binding.avatar.setImageBitmap(character.avatar)
        binding.checkbox.apply { setOnClickListener { listener.onFavoriteClick(isChecked, character) } }
    }
}
