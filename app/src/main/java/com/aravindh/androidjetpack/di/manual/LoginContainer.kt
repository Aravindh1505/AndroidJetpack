package com.aravindh.androidjetpack.di.manual

import android.app.Application

class LoginContainer(application: Application) {

    private val localDataSource = LocalDataSource(application)
    private val remoteLocalDataSource = RemoteDataSource(application)

    val loginRepository = LoginRepository(localDataSource, remoteLocalDataSource)
}