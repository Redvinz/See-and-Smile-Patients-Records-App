package com.example.finalsprojectics26011

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FirstActivity : AppCompatActivity(), OnLoginListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val admin = findViewById<Button>(R.id.admin)
        val client = findViewById<Button>(R.id.client)

        admin.setOnClickListener {
            val loginDialog = LoginDialog(this, this)
            loginDialog.show()
        }

        client.setOnClickListener {
            val intent = Intent(this, ClientMain::class.java)
            startActivity(intent)
        }
    }

    override fun onLoginSuccess() {
        // Handle successful login, navigate to the main activity, etc.
        // For now, let's navigate to MainActivity
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Optional: Close the current activity if needed
    }
}