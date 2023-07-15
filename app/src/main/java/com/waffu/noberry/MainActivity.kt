package com.waffu.noberry

import android.annotation.SuppressLint
import android.icu.text.DateFormat
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar
import java.util.Date


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val timeview: TextView = findViewById(R.id.currenttime)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.decorView.windowInsetsController!!.hide(
                android.view.WindowInsets.Type.statusBars()
                        or android.view.WindowInsets.Type.navigationBars()
            )
        } else {
            val decorView = window.decorView
            val uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
            decorView.systemUiVisibility = uiOptions
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            timeview.setText(DateFormat.getDateInstance(DateFormat.SHORT).format(Date(System.currentTimeMillis())))
        } else{
            val cal = Calendar.getInstance()
            val time = "" + cal[Calendar.HOUR_OF_DAY] + ":" + cal[Calendar.MINUTE]
            timeview.setText(time)
        };
    }
}