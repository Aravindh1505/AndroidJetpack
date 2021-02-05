package com.aravindh.androidjetpack.base

import android.app.Application
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class JetPackApplication : MultiDexApplication() {

}