package com.example.finalsprojectics26011

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

class FirstCategory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_category)

        val images: IntArray = intArrayOf(
            R.drawable.t1  ,
            R.drawable.t2
        )

        val viewPager: ViewPager = findViewById<View>(R.id.pager) as ViewPager

        val adapter: PagerAdapter = ImagePageAdapter(this, images)

        viewPager.adapter = adapter

        val skip = findViewById<Button>(R.id.skip)

        skip.setOnClickListener {
            val intent = Intent(this, ClientMain::class.java)
            startActivity(intent)
        }

        val dot1 = findViewById<ImageView>(R.id.indicator1)
        val dot2 = findViewById<ImageView>(R.id.indicator2)

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                updateDots(position, dot1, dot2)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

        // Set initial dot colors
        updateDots(0, dot1, dot2)

    }
    private fun updateDots(position: Int, dot1: ImageView, dot2: ImageView, ) {
        val dots = arrayOf(dot1, dot2)

        for (i in dots.indices) {
            dots[i].setImageResource(if (i == position) R.drawable.ic_dot_black else R.drawable.ic_dot_gray)
        }
    }
}