package com.example.empire.ui.recycler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.empire.databinding.CharacterRecyclerViewItemBinding
import com.example.empire.persistence.entities.Character
import com.example.empire.ui.recycler.diffs.CharacterDiffCallback
import com.example.empire.ui.recycler.viewholders.CharacterViewHolder
import com.example.empire.ui.recycler.FavoriteListener

class CharacterListAdapter(
    private val listener: FavoriteListener
) : ListAdapter<Character, CharacterViewHolder>(CharacterDiffCallback()) {

    private lateinit var binding: CharacterRecyclerViewItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        binding = CharacterRecyclerViewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }
}