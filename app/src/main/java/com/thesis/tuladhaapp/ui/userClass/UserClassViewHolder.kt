package com.thesis.tuladhaapp.ui.userClass

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.thesis.tuladhaapp.R
import com.thesis.tuladhaapp.databinding.ItemListCourseProgressBinding
import com.thesis.tuladhaapp.model.detailcourse.CourseData


class UserClassViewHolder(
    val binding: ItemListCourseProgressBinding,
    val itemClick: (CourseData) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(item: CourseData) {
        with(item) {
            binding.ivCourseImage.load(item.course?.imageUrl) {
                crossfade(true)
            }
            binding.tvCourseCategory.text = item.course?.updatedAt
            binding.tvTitleCourse.text = item.course?.name
            binding.tvCourseAuthor.text = itemView.rootView.context.getString(
                R.string.format_course_by,
                item.course?.courseBy
            )
            binding.tvCourseRate.text = item.course?.rating.toString()
            binding.tvCourseLevel.text = item.course?.level.toString()
            binding.tvCourseModules.text = item.course?.totalModule.toString() + " Modul"
            binding.tvCourseDuration.text = item.course?.totalDuration.toString()  + " Menit"
            binding.tvProgress.text = item.progress
            if (item.progress == "Selesai") {
                binding.tvProgress.setTextColor(itemView.rootView.context.getColor(R.color.color_success))

            }else{
                binding.tvProgress.setTextColor(itemView.rootView.context.getColor(R.color.color_warning))
            }
            itemView.setOnClickListener {
                itemClick(this)
            }
        }
    }
}
