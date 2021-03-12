package com.aravindh.androidjetpack.workmanager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.aravindh.androidjetpack.R
import com.aravindh.androidjetpack.utils.Logger
import com.aravindh.androidjetpack.utils.Utils.getCurrentDateAndTime
import com.aravindh.androidjetpack.utils.Utils.randomNumbers

const val INPUT_DATA = "INPUT_DATA"


class UploadWorker(context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {

    override fun doWork(): Result {
        Logger.d("doWork triggered....")

        val inputData = inputData.getString(INPUT_DATA)

        inputData?.let { displayNotification(title = "My Work", it) }
        return Result.success()
    }

    private fun displayNotification(title: String, task: String) {
        val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("Android JetPack", "Android JetPack", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }


        val notification: NotificationCompat.Builder = NotificationCompat.Builder(applicationContext, "Android JetPack")
            .setContentTitle(title)
            .setContentText(task + " " + getCurrentDateAndTime())
            .setSmallIcon(R.mipmap.ic_launcher)
        notificationManager.notify(randomNumbers(), notification.build())
    }


    fun uploadData() {

    }

}