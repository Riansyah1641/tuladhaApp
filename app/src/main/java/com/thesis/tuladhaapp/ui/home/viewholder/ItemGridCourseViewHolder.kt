package com.thesis.tuladhaapp.ui.home.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.thesis.tuladhaapp.model.course.Course
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.ItemGridCourseBinding
import com.thesis.tuladhaapp.utils.formatSecondsToMinutes
import com.thesis.tuladhaapp.utils.toCurrencyFormat

class ItemGridCourseViewHolder(
    private val binding: ItemGridCourseBinding,
    val itemClick: (Course) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Course) {
        with(item) {
            binding.ivCourseImage.load(item.imageUrl) {
                crossfade(true)
            }
            binding.tvCourseCategory.text = item.category?.name
            binding.tvCourseRate.text = item.rating.toString()
            binding.tvCourseName.text = item.name
            binding.tvCourseAuthor.text = itemView.rootView.context.getString(
                R.string.format_course_by,
                item.courseBy
            )
            binding.tvCourseLevel.text = item.level?.replaceFirstChar {
                it.uppercase()
            }
            binding.tvCourseDuration.text = itemView.rootView.context.getString(
                R.string.format_course_duration,
                item.totalDuration?.let { formatSecondsToMinutes(it) }
            )
            binding.tvCourseModules.text = itemView.rootView.context.getString(
                R.string.format_course_module,
                item.totalModule
            )
            if (item.price == 0) {
                binding.btnBuy.text = itemView.rootView.context.getString(R.string.text_free)
            } else {
                binding.btnBuy.text = itemView.rootView.context.getString(
                    R.string.format_btn_pelajari
                )
            }
            itemView.setOnClickListener {
                itemClick(this)
            }
        }
    }
}
