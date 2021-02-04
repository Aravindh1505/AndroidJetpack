package com.aravindh.androidjetpack.di.manual

import android.app.Application
import com.aravindh.androidjetpack.utils.Logger

class RemoteDataSource(private val application: Application) {

    init {
        Logger.d("RemoteDataSource initialized...")
    }
}