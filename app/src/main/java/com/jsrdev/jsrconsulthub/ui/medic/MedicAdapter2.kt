package com.jsrdev.jsrconsulthub.ui.medic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.jsrdev.jsrconsulthub.R
import com.jsrdev.jsrconsulthub.core.Constants
import com.jsrdev.jsrconsulthub.data.network.model.medic.GetMedicResponse
import com.jsrdev.jsrconsulthub.databinding.ItemMedicBinding


class MedicAdapter2(/*private val onItemClicked: (GetMedicResponse) -> Unit */)
    : ListAdapter<GetMedicResponse, MedicAdapter2.MedicViewHolder>(DiffCallback) {
    class MedicViewHolder(private var binding: ItemMedicBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(medic: GetMedicResponse) {
            val imgUrl: String = Constants.TEMPORAL_URL_IMAGE
            imgUrl.let {
                val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
                binding.userImage.load(imgUri) {
                    placeholder(R.drawable.loading_animation)
                    error(R.drawable.ic_broken_image)
                }
            }

            binding.medicName.text = "medic.name"
            binding.specialty.text = "medic.specialty?.name"
            binding.document.text = "medic.document"
            binding.email.text = "medic.email"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicViewHolder {
        return MedicViewHolder(ItemMedicBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MedicViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener { /*onItemClicked(current) */}
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