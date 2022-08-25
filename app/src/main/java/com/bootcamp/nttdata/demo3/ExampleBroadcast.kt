package com.bootcamp.nttdata.demo3

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log

class ExampleBroadcast : BroadcastReceiver() {

    private fun isOnline(context: Context?): Boolean {
        return try {
            val cm = context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = cm.activeNetworkInfo
            //should check null because in airplane mode it will be null
            netInfo != null && netInfo.isConnected
        } catch (e: NullPointerException) {
            println(e)
            e.printStackTrace()
            false
        }
    }

    override fun onReceive(context: Context?, intent: Intent?) {

        val intent = Intent(context, ServiceExample1::class.java)


        if (isOnline(context)) {
            Log.d("ExampleBroadcast: ", "Connected to Internet ");
            context?.startService(intent)
        } else {
            Log.d("ExampleBroadcast: ", "No Connectivity")
            context?.stopService(intent)
        }

    }
}