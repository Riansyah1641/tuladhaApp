package com.thesis.tuladhaapp.ui.detailCourse.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.thesis.tuladhaapp.databinding.ItemListBenefitCourseBinding
import com.thesis.tuladhaapp.model.course.CourseBenefit
import com.thesis.tuladhaapp.model.detailcourse.BenefitData

class BenefitListAdapter() : RecyclerView.Adapter<BenefitListViewHolder>() {

    private val dataDiffer =
        AsyncListDiffer(
            this,
            object : DiffUtil.ItemCallback<BenefitData>() {
                override fun areItemsTheSame(
                    oldItem: BenefitData,
                    newItem: BenefitData
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: BenefitData,
                    newItem: BenefitData
                ): Boolean {
                    return oldItem.hashCode() == newItem.hashCode()
                }
            }
        )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BenefitListViewHolder {
        val binding = ItemListBenefitCourseBinding.inflate(LayoutInflater.from(parent.context))
        return BenefitListViewHolder(binding)
    }

    override fun getItemCount(): Int = dataDiffer.currentList.size

    override fun onBindViewHolder(holder: BenefitListViewHolder, position: Int) {
        val currentItem = dataDiffer.currentList[position]
        holder.bind(currentItem)
    }

    fun submitData(data: List<BenefitData?>) {
        dataDiffer.submitList(data)
    }
}

class BenefitListViewHolder(
    private val binding: ItemListBenefitCourseBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: BenefitData) {
        binding.tvBenefitContent.text = item.description
        binding.tvNumber.text = item.no.toString()
    }
}
