package com.aravindh.androidjetpack.connectivity

import android.app.Application
import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.flow.MutableStateFlow

class ConnectivityManager(application: Application) {

    companion object {
        var isNetworkConnected = false
    }

    private val connectionLiveData = ConnectionLiveData(application)

    // observe this in ui
    val isNetworkAvailable = MutableStateFlow(false)

    fun registerConnectionObserver(lifecycleOwner: LifecycleOwner) {
        connectionLiveData.observe(lifecycleOwner, { isConnected ->
            isConnected?.let { isNetworkAvailable.value = it }
        })
    }

    fun unregisterConnectionObserver(lifecycleOwner: LifecycleOwner) {
        connectionLiveData.removeObservers(lifecycleOwner)
    }
}













