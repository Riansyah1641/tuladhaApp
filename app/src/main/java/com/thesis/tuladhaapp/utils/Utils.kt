package com.thesis.tuladhaapp.utils

import android.content.Context
import androidx.appcompat.app.AppCompatActivity.MODE_PRIVATE
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

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
    fun lastseenTime():String {
        val currentDate = Date()
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        return formatter.format(currentDate)
    }
}