package com.bootcamp.nttdata.demo3

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class ServiceExample1 : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("", "Service Started MyService ******************************* ")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("", "Service onStartCommand ******************************* ")

        return super.onStartCommand(intent, flags, startId)

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("", "Service Stop MyService ******************************* ")
    }
}