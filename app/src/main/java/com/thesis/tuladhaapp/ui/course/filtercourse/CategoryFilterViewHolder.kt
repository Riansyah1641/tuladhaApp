package com.thesis.tuladhaapp.ui.course.filtercourse

import androidx.recyclerview.widget.RecyclerView
import com.thesis.tuladhaapp.databinding.ItemCheckboxFilterBinding
import com.thesis.tuladhaapp.model.category.Category

import com.thesis.tuladhaapp.ui.course.filtercourse.CategoryItemListener

class CategoryFilterViewHolder(
    private val binding: ItemCheckboxFilterBinding,
    private val listener: CategoryItemListener
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Category) {
        with(item) {
            binding.cbItemCategory.text = item.categoryName
            binding.cbItemCategory.isChecked = listener.getSelectedCategories()?.contains(item) == true
            binding.cbItemCategory.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    listener.onCategoryChecked(item)
                } else {
                    listener.onCategoryUnchecked(item)
                }
            }
        }
    }
}
