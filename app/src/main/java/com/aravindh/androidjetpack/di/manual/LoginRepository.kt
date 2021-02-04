package com.aravindh.androidjetpack.di.manual

import com.aravindh.androidjetpack.utils.Logger

class LoginRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) {

    init {
        Logger.d("LoginRepository initialized...")
    }

    fun login() {
        Logger.d("login method called...")
    }
}