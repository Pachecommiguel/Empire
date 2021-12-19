package com.example.empire.ui.recycler.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.empire.databinding.VehicleRecyclerViewItemBinding
import com.example.empire.persistence.entities.Vehicle

class VehicleViewHolder(
    private val binding: VehicleRecyclerViewItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(vehicle: Vehicle?) {
        binding.vehicle = vehicle
    }
}
