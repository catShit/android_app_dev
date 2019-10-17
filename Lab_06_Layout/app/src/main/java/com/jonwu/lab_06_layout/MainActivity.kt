package com.jonwu.lab_06_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun display(view: View) {
        info.text = "Android Application Development, Android Security Essentials and Monetize Android Application"
        Log.v("lab06", "display called")
    }
}
