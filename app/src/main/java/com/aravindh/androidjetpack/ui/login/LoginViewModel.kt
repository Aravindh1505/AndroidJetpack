package com.aravindh.androidjetpack.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.aravindh.androidjetpack.network.NetworkRepository
import com.aravindh.androidjetpack.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class LoginViewModel @Inject constructor(val networkRepository: NetworkRepository) :
    ViewModel() {


    val employees = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null, message = "Loading"))
        try {
            emit(Resource.success(data = networkRepository.getEmployees(), message = "Success"))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun getToken(): String {
        return "Auth-Token"
    }

}