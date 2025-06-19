// com/thesis/tuladhaapp/ui/profile/ChildAdapter.kt (atau di package adapter Anda)
package com.thesis.tuladhaapp.ui.profile // Sesuaikan dengan lokasi file Anda

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.thesis.tuladhaapp.databinding.ItemChildBinding // Import binding untuk item layout
import com.thesis.tuladhaapp.model.firebase.ChildData

class ChildAdapter(
    private val onEditClick: (ChildData) -> Unit,
    private val onDeleteClick: (ChildData) -> Unit
) : ListAdapter<ChildData, ChildAdapter.ChildViewHolder>(ChildDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val binding = ItemChildBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChildViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        val child = getItem(position)
        holder.bind(child, onEditClick, onDeleteClick)
    }

    class ChildViewHolder(private val binding: ItemChildBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(child: ChildData, onEditClick: (ChildData) -> Unit, onDeleteClick: (ChildData) -> Unit) {
            binding.tvChildName.text = "Nama Anak: ${child.name}"
            binding.tvChildAgeRange.text = "Usia: ${child.ageRange}"
            binding.tvChildGender.text = "Jenis Kelamin: ${child.gender}"

            binding.btnEditChild.setOnClickListener { onEditClick(child) }
            binding.btnDeleteChild.setOnClickListener { onDeleteClick(child) }
        }
    }

    // Callback untuk RecyclerView.Adapter.ListAdapter agar update lebih efisien
    class ChildDiffCallback : DiffUtil.ItemCallback<ChildData>() {
        override fun areItemsTheSame(oldItem: ChildData, newItem: ChildData): Boolean {
            return oldItem.id == newItem.id // Bandingkan berdasarkan ID unik anak
        }

        override fun areContentsTheSame(oldItem: ChildData, newItem: ChildData): Boolean {
            // Bandingkan semua properti yang relevan untuk mendeteksi perubahan konten
            return oldItem == newItem
        }
    }
}