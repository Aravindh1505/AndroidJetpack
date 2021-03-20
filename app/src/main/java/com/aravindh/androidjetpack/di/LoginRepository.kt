package com.aravindh.androidjetpack.di

import com.aravindh.androidjetpack.utils.Logger
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepository @Inject constructor(
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