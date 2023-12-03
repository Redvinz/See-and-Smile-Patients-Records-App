package com.example.finalsprojectics26011

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class UpdateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        val btnUpdate = findViewById<ImageButton>(R.id.btnUpdate)
        btnUpdate.setOnClickListener {
            updateRecord()
        }

        getAndSetIntentData()
    }

    private fun getAndSetIntentData() {
        if (intent.hasExtra("name") &&
            intent.hasExtra("address") &&
            intent.hasExtra("age") &&
            intent.hasExtra("contact") &&
            intent.hasExtra("appointment") &&
            intent.hasExtra("od") &&
            intent.hasExtra("os") &&
            intent.hasExtra("add") &&
            intent.hasExtra("pd") &&
            intent.hasExtra("frame") &&
            intent.hasExtra("lens") &&
            intent.hasExtra("laboratory") &&
            intent.hasExtra("price")
        ) {
            // Getting data from Intent
            val name = intent.getStringExtra("name")
            val address = intent.getStringExtra("address")
            val age = intent.getStringExtra("age")
            val contact = intent.getStringExtra("contact")
            val appointment = intent.getStringExtra("appointment")
            val od = intent.getStringExtra("od")
            val os = intent.getStringExtra("os")
            val add = intent.getStringExtra("add")
            val pd = intent.getStringExtra("pd")
            val frame = intent.getStringExtra("frame")
            val lens = intent.getStringExtra("lens")
            val laboratory = intent.getStringExtra("laboratory")
            val price = intent.getStringExtra("price")

            // Setting Intent Data
            val etName = findViewById<TextInputEditText>(R.id.etName2)
            val etAddress = findViewById<TextInputEditText>(R.id.etAddress2)
            val etAge = findViewById<TextInputEditText>(R.id.etAge2)
            val etContact = findViewById<TextInputEditText>(R.id.etContact2)
            val etAppointment = findViewById<TextInputEditText>(R.id.etAppointment2)
            val etOD = findViewById<TextInputEditText>(R.id.etOD2)
            val etOS = findViewById<TextInputEditText>(R.id.etOS2)
            val etAdd = findViewById<TextInputEditText>(R.id.etAdd2)
            val etPD = findViewById<TextInputEditText>(R.id.etPD2)
            val etFrame = findViewById<TextInputEditText>(R.id.etFrame2)
            val etLens = findViewById<TextInputEditText>(R.id.etLens2)
            val etLaboratory = findViewById<TextInputEditText>(R.id.etLaboratory2)
            val etPrice = findViewById<TextInputEditText>(R.id.etPrice2)

            etName.setText(name)
            etAddress.setText(address)
            etAge.setText(age)
            etContact.setText(contact)
            etAppointment.setText(appointment)
            etOD.setText(od)
            etOS.setText(os)
            etAdd.setText(add)
            etPD.setText(pd)
            etFrame.setText(frame)
            etLens.setText(lens)
            etLaboratory.setText(laboratory)
            etPrice.setText(price)

        } else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateRecord() {
        // Assuming MyDatabaseHelper is your database helper class
        val myDB = MyDatabaseHelper(this)



        // Optionally, you can show a message indicating that the record has been updated
        Toast.makeText(this, "Record updated successfully", Toast.LENGTH_SHORT).show()

        // Navigate back to MainActivity
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
