package com.aravindh.androidjetpack.di.manual

import android.app.Application
import com.aravindh.androidjetpack.utils.Logger
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val application: Application) {

    init {
        Logger.d("RemoteDataSource initialized...")
    }
}