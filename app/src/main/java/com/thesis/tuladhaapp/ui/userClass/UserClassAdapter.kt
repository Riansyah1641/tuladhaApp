package com.thesis.tuladhaapp.ui.userClass

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.thesis.tuladhaapp.databinding.ItemListCourseProgressBinding
import com.thesis.tuladhaapp.model.detailcourse.CourseData


class UserClassAdapter(
    val itemClick: (CourseData) -> Unit
) : RecyclerView.Adapter<UserClassViewHolder>() {

    private val dataDiffer =
        AsyncListDiffer(
            this,
            object : DiffUtil.ItemCallback<CourseData>() {
                override fun areItemsTheSame(
                    oldItem: CourseData,
                    newItem: CourseData
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: CourseData,
                    newItem: CourseData
                ): Boolean {
                    return oldItem.hashCode() == newItem.hashCode()
                }
            }
        )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserClassViewHolder {
        val binding = ItemListCourseProgressBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserClassViewHolder(binding, itemClick)
    }

    override fun getItemCount(): Int = dataDiffer.currentList.size

    override fun onBindViewHolder(holder: UserClassViewHolder, position: Int) {
        holder.bind(dataDiffer.currentList[position])
    }

    fun submitList(data: List<CourseData>) {
        dataDiffer.submitList(data)
    }
}
