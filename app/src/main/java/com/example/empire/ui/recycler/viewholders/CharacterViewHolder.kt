package com.example.empire.ui.recycler.viewholders

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.empire.databinding.CharacterRecyclerViewItemBinding
import com.example.empire.persistence.entities.Character
import com.example.empire.ui.recycler.FavoriteListener
import com.example.empire.ui.recycler.adapters.VehicleListAdapter

class CharacterViewHolder(
    private val binding: CharacterRecyclerViewItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(character: Character, listener: FavoriteListener) {
        binding.character = character
        binding.avatar.setImageBitmap(character.avatar)
        binding.layout.setOnClickListener { listener.onItemClick(character) }

        binding.checkbox.apply { setOnClickListener {
            listener.onFavoriteClick(isChecked, character)
        }}

        if (character.vehicles.isNotEmpty()) {
            binding.vehicles.visibility = View.VISIBLE

            VehicleListAdapter().let {
                binding.vehicleRecyclerview.apply {
                    adapter = it
                    layoutManager = LinearLayoutManager(binding.vehicleRecyclerview.context)
                }
                it.submitList(character.vehicles)
            }
        }
    }
}
