package com.thesis.tuladhaapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.ItemListCategoryBinding
import com.thesis.tuladhaapp.model.category.Category
import com.thesis.tuladhaapp.ui.home.viewholder.ItemListCategoryViewHolder


class PopularCourseCategoryAdapter(private val itemClick: (Category) -> Unit) :
    RecyclerView.Adapter<ItemListCategoryViewHolder>() {

    private var selectedPosition: Int? = 0

    private val dataDiffer =
        AsyncListDiffer(
            this,
            object : DiffUtil.ItemCallback<Category>() {
                override fun areItemsTheSame(
                    oldItem: Category,
                    newItem: Category
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: Category,
                    newItem: Category
                ): Boolean {
                    return oldItem.hashCode() == newItem.hashCode()
                }
            }
        )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListCategoryViewHolder {
        val binding = ItemListCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemListCategoryViewHolder(binding, itemClick)
    }

    override fun getItemCount(): Int = dataDiffer.currentList.size

    override fun onBindViewHolder(holder: ItemListCategoryViewHolder, position: Int) {
        val category = dataDiffer.currentList[position]
        holder.bind(category)
        holder.itemView.setOnClickListener {
            itemClick(category)
        }
        holder.itemView.setBackgroundResource(
            if (category.id == selectedPosition) R.drawable.bg_primary_rounded else android.R.color.transparent
        )
    }

    fun submitData(data: List<Category>) {
        dataDiffer.submitList(data)
    }

    fun setSelectedCategory(selectedCategory: Category?) {
        val previousPosition = this.selectedPosition
        this.selectedPosition = selectedCategory?.id

        if (previousPosition != null) {
            notifyItemChanged(previousPosition)
        }
        if (selectedCategory != null) {
            notifyItemChanged(selectedCategory.id)
        }
    }
}
