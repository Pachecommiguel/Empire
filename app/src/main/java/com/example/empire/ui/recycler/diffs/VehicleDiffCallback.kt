package com.example.empire.ui.recycler.diffs

import androidx.recyclerview.widget.DiffUtil
import com.example.empire.persistence.entities.Vehicle

class VehicleDiffCallback : DiffUtil.ItemCallback<Vehicle>() {
    override fun areItemsTheSame(oldItem: Vehicle, newItem: Vehicle): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: Vehicle, newItem: Vehicle): Boolean = oldItem == newItem
}
