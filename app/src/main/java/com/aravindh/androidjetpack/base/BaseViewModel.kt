package com.aravindh.androidjetpack.base

import androidx.lifecycle.ViewModel
import com.aravindh.androidjetpack.network.NetworkRepository
import javax.inject.Inject
import javax.inject.Named


open class BaseViewModel : ViewModel() {

    @Inject
    lateinit var networkRepository: NetworkRepository
}