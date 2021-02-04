package com.aravindh.androidjetpack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.aravindh.androidjetpack.base.JetPackApplication
import com.aravindh.androidjetpack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupLoginRepository()

        binding.buttonLogin.setOnClickListener {
            setupLoginRepository()
        }

    }

    private fun setupLoginRepository() {
        val loginContainer = (application as JetPackApplication).loginContainer
        loginContainer.loginRepository.login()
    }
}
