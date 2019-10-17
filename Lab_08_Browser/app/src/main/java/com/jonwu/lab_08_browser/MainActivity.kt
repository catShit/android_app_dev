package com.jonwu.lab_08_browser

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        var id = "my_channel_02"

        val name = "android atc action"
        val description = "android atc action"
        val importance = NotificationManager.IMPORTANCE_HIGH
        val mChannel = NotificationChannel(id, name, importance)

        mChannel.description = description
        mChannel.enableLights(true)

        mChannel.lightColor = Color.RED
        mChannel.enableVibration(true)
        mNotificationManager.createNotificationChannel(mChannel)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        mywebview.webViewClient = WebViewClient()

        when(item?.itemId) {
            R.id.item1 -> {mywebview.loadUrl("http://www.androidatc.com")
                val CHANNEL_ID = "my_channel_02"
                val mBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle("Android ATC Notification")
                    .setContentText("Check Android ATC New Course !!")
                val resultIntent = Intent(this, ResultActivity::class.java)

                val stackBuilder = TaskStackBuilder.create(this)

                stackBuilder.addNextIntent(resultIntent)
                val resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
                mBuilder.setContentIntent(resultPendingIntent)

                val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


                mNotificationManager.notify(2, mBuilder.build())
            }
            R.id.item2 -> {mywebview.loadUrl("http://www.pearsonvue.com/androidatc")}
        }
        return super.onOptionsItemSelected(item)
    }

    fun gotoweb(view: View) {
        mywebview.settings.javaScriptEnabled = true
        mywebview.settings.loadsImagesAutomatically = true
        mywebview.settings.domStorageEnabled = true
        mywebview.scrollBarStyle = View.SCROLLBARS_INSIDE_OVERLAY

        val url = url_address.text.toString()
        mywebview.webViewClient = WebViewClient()
        mywebview.loadUrl(url)
    }
}
