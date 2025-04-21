package com.thesis.tuladhaapp.ui.home.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.thesis.tuladhaapp.databinding.ItemGridCategoriesBinding
import com.thesis.tuladhaapp.databinding.ItemListCategoryBinding
import com.thesis.tuladhaapp.model.category.Category

class ItemGridCategoryViewHolder(
    private val binding: ItemGridCategoriesBinding,
    val itemClick: (Category) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Category) {
        with(item) {
            binding.imageCategories.load(item.categoryImage)
            binding.tvCategoriesName.text = item.categoryName
            itemView.setOnClickListener {
                itemClick(this)
            }
        }
    }
}

class ItemListCategoryViewHolder(
    private val binding: ItemListCategoryBinding,
    val itemClick: (Category) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Category) {
        with(item) {
            binding.tvCategoryName.text = item.categoryName
            itemView.setOnClickListener {
                itemClick(this)
            }
        }
    }
}
