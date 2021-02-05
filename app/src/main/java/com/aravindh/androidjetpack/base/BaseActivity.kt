package com.aravindh.androidjetpack.base

import androidx.appcompat.app.AppCompatActivity
import com.aravindh.androidjetpack.di.manual.LoginRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
open class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var testString: String

    @Inject
    lateinit var loginRepository: LoginRepository
}