package com.bootcamp.nttdata.demo3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val fragmentExample = FragmentExample()
        fragmentTransaction.add(R.id.fragmentExample, FragmentExample.newInstance())
        //fragmentTransaction.add(R.id.fragmentExample, fragmentExample)
        fragmentTransaction.commit()
    }
}