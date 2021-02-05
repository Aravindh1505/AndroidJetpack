package com.aravindh.androidjetpack

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.aravindh.androidjetpack.base.BaseActivity
import com.aravindh.androidjetpack.base.JetPackApplication
import com.aravindh.androidjetpack.databinding.ActivityMainBinding
import com.aravindh.androidjetpack.di.manual.LoginRepository
import com.aravindh.androidjetpack.utils.Logger
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        Logger.d("testString : $testString")


        loginRepository.login()
    }
}
