package com.example.finalsprojectics26011

import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ClientMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_main)

        val cat1 = findViewById<ImageView>(R.id.treatments)
        val cat2 = findViewById<ImageView>(R.id.clinicinfo)
        val cat3 = findViewById<ImageView>(R.id.healthtips)

        val browse1 = findViewById<ImageView>(R.id.browse1)
        val browse2 = findViewById<ImageView>(R.id.browse2)
        val browse3 = findViewById<ImageView>(R.id.browse3)

        val first = findViewById<ImageView>(R.id.toFirst)
        first.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
        }

        cat1.setOnClickListener {
            val intent = Intent(this, FirstCategory::class.java)
            startActivity(intent)
        }

        cat2.setOnClickListener {
            val intent = Intent(this, SecondCategory::class.java)
            startActivity(intent)
        }

        cat3.setOnClickListener {
            val intent = Intent(this, ThirdCategory::class.java)
            startActivity(intent)
        }

        browse1.setOnClickListener {
            val url = "https://www.facebook.com/seeandsmiledentalandoptical"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        browse2.setOnClickListener {
            val url = "https://www.sarahpalmerdds.com/7-tips-for-healthy-teeth-and-gums.php"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        browse3.setOnClickListener {
            val url = "https://www.cnet.com/health/personal-care/10-daily-ways-to-boost-your-eye-health-naturally/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }
}