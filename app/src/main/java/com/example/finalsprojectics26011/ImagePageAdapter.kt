package com.example.finalsprojectics26011

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import java.util.zip.Inflater

class ImagePageAdapter (var context: Context, private var images: IntArray): PagerAdapter(){
    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val image: ImageView
        val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = inflater.inflate(R.layout.pager_item, container, false)

        image = itemView.findViewById<View>(R.id.imageView) as ImageView

        image.setImageResource(images[position])

        (container as ViewPager).addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        (container as ViewPager).removeView(`object` as RelativeLayout)
    }


}