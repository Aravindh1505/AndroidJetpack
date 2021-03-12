package com.aravindh.androidjetpack.utils

import java.text.SimpleDateFormat
import java.util.*

object Utils {

    fun randomNumbers(): Int {
        return (1..100).random()
    }

    fun getCurrentDateAndTime(): String {
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())
        println(" C DATE is  $currentDate")
        return currentDate
    }

}