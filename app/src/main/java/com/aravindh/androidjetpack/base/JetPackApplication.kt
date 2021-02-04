package com.aravindh.androidjetpack.base

import android.app.Application
import com.aravindh.androidjetpack.di.manual.LoginContainer

class JetPackApplication : Application() {

    val loginContainer = LoginContainer(this)

}