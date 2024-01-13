package com.jsrdev.jsrconsulthub.ui.medic

import android.util.Log
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

class MedicAdapter(
    private var medicList: List<GetMedicResponse> = emptyList(),
    private val onMedicClicked: (GetMedicResponse) -> Unit
) : ListAdapter<GetMedicResponse, MedicAdapter.MedicViewHolder>(DiffCallback) {
    class MedicViewHolder(private var binding: ItemMedicBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(medic: GetMedicResponse) {

            Log.i("MedicAdapter", "Response in adapter: $medic")

            medic.name?.let { name ->
                binding.medicName.text = name
            }
            medic.specialty?.name.let{ specialty ->
                binding.specialty.text = specialty
            }
            medic.document?.let { document ->
                binding.document.text = document
            }
            medic.email?.let { email ->
                binding.email.text = email
            }

            val imgUrl: String = Constants.TEMPORAL_URL_IMAGE
            imgUrl.let {
                val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
                binding.userImage.load(imgUri) {
                    placeholder(R.drawable.loading_animation)
                    error(R.drawable.ic_broken_image)
                }
            }
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

    companion object {
        private val DiffCallback = object: DiffUtil.ItemCallback<GetMedicResponse>() {
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

    // filter
    fun updateMedic(newMedicList: List<GetMedicResponse>) {
        val diffResult = DiffUtil.calculateDiff(MedicDiffCallback(medicList, newMedicList))
        medicList = newMedicList
        diffResult.dispatchUpdatesTo(this)
    }

    class MedicDiffCallback(
        private val oldList: List<GetMedicResponse>,
        private val newList: List<GetMedicResponse>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size
        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }


}