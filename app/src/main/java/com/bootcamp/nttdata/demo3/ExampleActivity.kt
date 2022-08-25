package com.bootcamp.nttdata.demo3

import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ExampleActivity : AppCompatActivity() {

    lateinit var broadcast : ExampleBroadcast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)
        broadcast = ExampleBroadcast()
        registerForNetworkBroadcast()
    }

    private fun registerForNetworkBroadcast() {
        registerReceiver(
            broadcast,
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )
    }

    private fun unregisterNetworkChanges() {
        try {
            unregisterReceiver(broadcast)
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterNetworkChanges()
    }
}