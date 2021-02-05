package com.aravindh.androidjetpack.base

import androidx.lifecycle.ViewModel
import com.aravindh.androidjetpack.network.NetworkRepository
import javax.inject.Inject


class BaseViewModel : ViewModel() {

    @Inject
    lateinit var networkRepository: NetworkRepository
}