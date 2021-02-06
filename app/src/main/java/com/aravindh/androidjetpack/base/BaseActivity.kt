package com.aravindh.androidjetpack.base

import androidx.appcompat.app.AppCompatActivity
import com.aravindh.androidjetpack.network.NetworkRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
open class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var networkRepository: NetworkRepository
}