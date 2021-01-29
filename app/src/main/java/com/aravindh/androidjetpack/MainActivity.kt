package com.aravindh.androidjetpack

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.localazy.android.Localazy
import java.util.*

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        locale()
    }

    private fun locale() {
        val currentLocale: Locale = Localazy.getCurrentLocale()
        Log.d(TAG, "lang : ${currentLocale.language}")

        Log.d(TAG, "isEnabled : ${Localazy.isEnabled()}")

        val localeHi = Locale("ta")
        Localazy.forceLocale(localeHi, false)
    }
}
