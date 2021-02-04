package com.aravindh.androidjetpack.di.manual

import android.app.Application
import com.aravindh.androidjetpack.utils.Logger

class LocalDataSource(private val application: Application) {

    init {
        Logger.d("LocalDataSource initialized...")
    }
}