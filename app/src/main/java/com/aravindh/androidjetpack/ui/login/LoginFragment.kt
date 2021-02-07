package com.aravindh.androidjetpack.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.aravindh.androidjetpack.connectivity.ConnectivityManager
import com.aravindh.androidjetpack.databinding.FragmentLoginBinding
import com.aravindh.androidjetpack.utils.Logger
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {

        binding.buttonLogin.setOnClickListener {
            if (ConnectivityManager.isNetworkConnected) {
                viewModel.callAPI()
            } else {
                Logger.d("Network not connected...")
            }
        }


        lifecycleScope.launchWhenStarted {
            viewModel.login.collect { event ->
                when (event) {
                    is LoginViewModel.LoginEvent.Loading -> Logger.d("Loading")
                    is LoginViewModel.LoginEvent.Failure -> Logger.d(event.errorText)
                    is LoginViewModel.LoginEvent.Success -> Logger.d(event.workDataResponse.toString())
                    else -> Unit
                }
            }
        }
    }
}