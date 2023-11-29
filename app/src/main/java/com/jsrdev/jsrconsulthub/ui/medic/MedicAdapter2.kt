package com.jsrdev.jsrconsulthub.ui.medic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jsrdev.jsrconsulthub.data.network.model.medic.GetMedicResponse
import com.jsrdev.jsrconsulthub.databinding.ItemMedicBinding


class MedicAdapter2(private val onItemClicked: (GetMedicResponse) -> Unit)
    : ListAdapter<GetMedicResponse, MedicAdapter2.MedicViewHolder>(DiffCallback) {
    class MedicViewHolder(private var binding: ItemMedicBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(medic: GetMedicResponse) {
            binding.medicName.text = medic.name
            binding.specialty.text = medic.specialty.name
            binding.document.text = medic.document
            binding.email.text = medic.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicViewHolder {
        return MedicViewHolder(ItemMedicBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MedicViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener { onItemClicked(current)}
        holder.bind(current)
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<GetMedicResponse>() {
            override fun areItemsTheSame(
                oldItem: GetMedicResponse,
                newItem: GetMedicResponse
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: GetMedicResponse,
                newItem: GetMedicResponse
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}