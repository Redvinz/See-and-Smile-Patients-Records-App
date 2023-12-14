package com.example.finalsprojectics26011

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

class SecondCategory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_category)

        val home = findViewById<Button>(R.id.skip)
        home.setOnClickListener {
            val intent = Intent(this, ClientMain::class.java)
            startActivity(intent)
        }

    }
}
