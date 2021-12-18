package com.example.empire.ui.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import com.example.empire.databinding.CharacterRecyclerViewItemBinding
import com.example.empire.persistence.entities.Character

class CharacterListAdapter : ListAdapter<Character, CharacterViewHolder>(CharacterDiffCallback()) {

    private lateinit var binding: CharacterRecyclerViewItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder =
        CharacterViewHolder(CharacterRecyclerViewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ).also { binding = it })

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = getItem(position)
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        item.vehicles.forEach {
            binding.vehicles.visibility = View.VISIBLE
            it?.let {
                TextView(holder.itemView.context).apply {
                    layoutParams = params
                    text = it
                }.also { binding.layout.addView(it) }
            }
        }

        holder.bind(item)
    }
}