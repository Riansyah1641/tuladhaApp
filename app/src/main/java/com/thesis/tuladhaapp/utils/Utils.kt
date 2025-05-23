package com.thesis.tuladhaapp.utils

import android.content.Context
import androidx.appcompat.app.AppCompatActivity.MODE_PRIVATE

object Utils {

    fun saveHighScore(context: Context, percentage: Float){
        val sharedPreferences = context.getSharedPreferences("QuizPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("scorePercentage", percentage.toInt())
        editor.apply()
    }
    fun getHighScore(context: Context):Int{
        val sharedPreferences = context.getSharedPreferences("QuizPrefs", MODE_PRIVATE)
        val percentage = sharedPreferences.getInt("scorePercentage", 0)
        return percentage
    }
}