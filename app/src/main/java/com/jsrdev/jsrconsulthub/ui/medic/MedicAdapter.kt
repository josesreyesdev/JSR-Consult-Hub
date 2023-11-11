package com.jsrdev.jsrconsulthub.ui.medic

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jsrdev.jsrconsulthub.data.network.model.medic.GetMedicResponse
import com.jsrdev.jsrconsulthub.databinding.ItemMedicBinding

class MedicAdapter(
    private val onMedicClicked: (GetMedicResponse) -> Unit,
    private var medicList: List<GetMedicResponse>
) : ListAdapter<GetMedicResponse, MedicAdapter.MedicViewHolder>(DiffCallback) {
    class MedicViewHolder(private var binding: ItemMedicBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(medic: GetMedicResponse) {
            binding.medicName.text = medic.name
            binding.specialty.text = medic.specialty.toString()
            binding.document.text = medic.document
            binding.email.text = medic.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicViewHolder {
        return MedicViewHolder(ItemMedicBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MedicViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener { onMedicClicked(current) }
        holder.bind(current)
    }

    override fun getItemCount() : Int = medicList.size

    // filter
    fun updateMedic(medicList: List<GetMedicResponse>) {
        this.medicList = medicList
        notifyDataSetChanged()
    }

    companion object {
        private val DiffCallback = object: DiffUtil.ItemCallback<GetMedicResponse>() {
            override fun areItemsTheSame(
                oldItem: GetMedicResponse,
                newItem: GetMedicResponse
            ): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(
                oldItem: GetMedicResponse,
                newItem: GetMedicResponse
            ): Boolean {
                return oldItem.id == newItem.id
            }

        }
    }


}