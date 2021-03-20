package com.aravindh.androidjetpack.workmanager

import android.app.Application
import androidx.work.*
import java.util.concurrent.TimeUnit

class CustomWorkManager(private val applicationContext: Application) {

    fun workManagerOneTimeWorkRequestBuilder() {

        /*Data Input*/
        val dataInput = Data.Builder().putString(INPUT_DATA, "This is input data from MainActivity").build()

        /*WorkManager Constraints*/
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
            .build()

        /*Work Request*/
        val uploadWorkRequest = OneTimeWorkRequestBuilder<UploadWorker>()
            .setInputData(dataInput)
            .setConstraints(constraints)
            .build()

        /*Enqueue*/
        val workManager = WorkManager.getInstance(applicationContext).enqueue(uploadWorkRequest)

        //Listening to the work status
/*
        WorkManager.getInstance().getWorkInfoByIdLiveData(uploadWorkRequest.id)
            .observe(this, {
                Logger.d("onChanged : ${it.state.name}")
            })
*/
    }

    fun workManagerPeriodicWorkRequestBuilder() {

        /*Data Input*/
        val dataInput = Data.Builder().putString(INPUT_DATA, "This is input data from MainActivity").build()

        /*WorkManager Constraints*/
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
            .build()

        /*Work Request*/
        val uploadWorkRequest = PeriodicWorkRequestBuilder<UploadWorker>(20, TimeUnit.MINUTES)
            .setInputData(dataInput)
            .setConstraints(constraints)
            .build()

        /*Enqueue*/
        val workManager = WorkManager.getInstance(applicationContext).enqueue(uploadWorkRequest)

        //Listening to the work status
/*
        WorkManager.getInstance().getWorkInfoByIdLiveData(uploadWorkRequest.id)
            .observe(this, {
                Logger.d("onChanged : ${it.state.name}")
            })
*/
    }

}