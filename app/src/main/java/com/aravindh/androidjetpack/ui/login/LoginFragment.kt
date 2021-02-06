package com.aravindh.androidjetpack.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.aravindh.androidjetpack.databinding.FragmentLoginBinding
import com.aravindh.androidjetpack.network.Status
import com.aravindh.androidjetpack.utils.Logger
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    //    private val viewModel: LoginViewModel by viewModels()
    private val viewModel: LoginViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        Logger.d("token : ${viewModel.getToken()}")

        viewModel.employees.observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        Logger.d("SUCCESS")
                        resource.data?.let { world -> world.toString() }
                    }
                    Status.ERROR -> {
                        Logger.d("ERROR")
                    }
                    Status.LOADING -> {
                        Logger.d("LOADING")
                    }
                }
            }
        })
    }
}