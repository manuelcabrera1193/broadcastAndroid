package com.bootcamp.nttdata.demo3

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class MyActivity2 : AppCompatActivity() {

    lateinit var button: AppCompatButton


    lateinit var broadcast: ExampleBroadcast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_2)

        button = findViewById(R.id.goSecondActivity)

        button.setOnClickListener {
            var intent = Intent(this, MyActivity::class.java)
            val bundle = Bundle()
            bundle.putInt("valueInt", 10)
            startActivityForResult(intent, 2022, bundle)
        }
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
            Log.i("unregister", "Se destruyo el broadcast **************** ")
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterNetworkChanges()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.i("onActivityResult: ", requestCode.toString())
        Log.i("onActivityResult: ", resultCode.toString())
        Log.i("onActivityResult: ", data.toString())

        if (resultCode == 2023) {
            Log.i("onActivityResult: ", "Viene desde la activity myActivity")
        }
    }

}