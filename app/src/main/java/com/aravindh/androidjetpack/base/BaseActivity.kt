package com.aravindh.androidjetpack.base

import androidx.appcompat.app.AppCompatActivity
import com.aravindh.androidjetpack.network.NetworkRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
open class BaseActivity : AppCompatActivity() {

    @Inject
    @Named("token")
    lateinit var token: String

    @Inject
    lateinit var networkRepository: NetworkRepository
}