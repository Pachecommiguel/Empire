package com.example.empire.ui.recycler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.empire.databinding.VehicleRecyclerViewItemBinding
import com.example.empire.persistence.entities.Vehicle
import com.example.empire.ui.recycler.diffs.VehicleDiffCallback
import com.example.empire.ui.recycler.viewholders.VehicleViewHolder

class VehicleListAdapter : ListAdapter<Vehicle, VehicleViewHolder>(VehicleDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder =
        VehicleViewHolder(
            VehicleRecyclerViewItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}