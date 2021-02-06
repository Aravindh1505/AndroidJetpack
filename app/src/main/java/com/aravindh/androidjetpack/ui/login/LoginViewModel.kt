package com.aravindh.androidjetpack.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aravindh.androidjetpack.network.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val networkRepository: NetworkRepository) :
    ViewModel() {

    private val _login = MutableStateFlow<LoginEvent>(LoginEvent.Empty)
    val login: StateFlow<LoginEvent> = _login

    sealed class LoginEvent {
        class Success(val workDataResponse: WorldDataResponse?) : LoginEvent()
        class Failure(val errorText: String?) : LoginEvent()
        object Loading : LoginEvent()
        object Empty : LoginEvent()
    }


    init {
        callAPI()
    }

    fun callAPI() {
        viewModelScope.launch(Dispatchers.IO) {
            _login.value = LoginEvent.Loading

            try {
                val response = networkRepository.getEmployees()
                _login.value = LoginEvent.Success(response)
            } catch (e: Exception) {
                _login.value = LoginEvent.Failure(e.message)
            }
        }
    }
}