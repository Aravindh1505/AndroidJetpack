package com.aravindh.androidjetpack.di

import android.app.Application
import com.aravindh.androidjetpack.utils.Logger
import javax.inject.Inject

class LocalDataSource @Inject constructor (private val application: Application) {

    init {
        Logger.d("LocalDataSource initialized...")
    }
}