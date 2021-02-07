package com.aravindh.androidjetpack

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.aravindh.androidjetpack.base.BaseActivity
import com.aravindh.androidjetpack.databinding.ActivityMainBinding


class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


       /* lifecycleScope.launchWhenStarted {
            connectivityManager.isNetworkAvailable.collect {
                Logger.d("isNetworkAvailable : $it")

                if (it) {
                    val response = networkRepository.getEmployees()
                    Logger.d("getEmployees response : $response")
                }
            }
        }*/
    }
}
