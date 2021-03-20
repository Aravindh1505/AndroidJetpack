package com.aravindh.androidjetpack

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.aravindh.androidjetpack.base.BaseActivity
import com.aravindh.androidjetpack.databinding.ActivityMainBinding
import com.aravindh.androidjetpack.workmanager.CustomWorkManager


class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        CustomWorkManager(application).workManagerPeriodicWorkRequestBuilder()
    }
}
