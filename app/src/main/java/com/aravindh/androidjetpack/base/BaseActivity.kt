package com.aravindh.androidjetpack.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.aravindh.androidjetpack.connectivity.ConnectivityManager
import com.aravindh.androidjetpack.di.LoginRepository
import com.aravindh.androidjetpack.network.NetworkRepository
import com.aravindh.androidjetpack.utils.Logger
import com.aravindh.androidjetpack.utils.Utils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@AndroidEntryPoint
open class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var networkRepository: NetworkRepository

    @Inject
    lateinit var connectivityManager: ConnectivityManager

    @Inject
    lateinit var loginRepository: LoginRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        connectivityManager.registerConnectionObserver(this)

//        loginRepository.login()

        lifecycleScope.launchWhenStarted {
            connectivityManager.isNetworkAvailable.collect {
//                Logger.d("isNetworkAvailable : $it")
                ConnectivityManager.isNetworkConnected = it
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        connectivityManager.unregisterConnectionObserver(this)
    }
}