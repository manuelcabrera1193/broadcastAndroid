package com.bootcamp.nttdata.demo3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)

        setResult(2023)
    }
}