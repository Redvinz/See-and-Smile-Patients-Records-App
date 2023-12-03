package com.example.finalsprojectics26011

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    // Initialize MyDatabaseHelper
    private lateinit var myDB: MyDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val btnAdd = findViewById<ImageButton>(R.id.btnAdd)

        // Initialize MyDatabaseHelper
        myDB = MyDatabaseHelper(this)

        // Arrays to store patient data
        val patient_name = ArrayList<String>()
        val patient_address = ArrayList<String>()
        val patient_age = ArrayList<String>()
        val patient_contact = ArrayList<String>()
        val patient_appointment = ArrayList<String>()
        val patient_od = ArrayList<String>()
        val patient_os = ArrayList<String>()
        val patient_add = ArrayList<String>()
        val patient_pd = ArrayList<String>()
        val patient_frame = ArrayList<String>()
        val patient_lens = ArrayList<String>()
        val patient_laboratory = ArrayList<String>()
        val patient_price = ArrayList<String>()

        // Call the function to populate arrays
        storeDataInArrays(
            patient_name,
            patient_address, patient_age, patient_contact,
            patient_appointment, patient_od, patient_os, patient_add, patient_pd, patient_frame,
            patient_lens, patient_laboratory, patient_price)

        // Create an instance of CustomAdapter
        val customAdapter = CustomAdapter(
            this,
            this,
            patient_name,
            patient_address,
            patient_age,
            patient_contact,
            patient_appointment,
            patient_od,
            patient_os,
            patient_add,
            patient_pd,
            patient_frame,
            patient_lens,
            patient_laboratory,
            patient_price

        )

        // Set the adapter and layout manager for the RecyclerView
        recyclerView.adapter = customAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Add click listener to the add button
        btnAdd.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
    }

    // Function to fetch data from the database and populate arrays
    private fun storeDataInArrays(
        patient_name: ArrayList<String>,
        patient_address: ArrayList<String>,
        patient_age: ArrayList<String>,
        patient_contact: ArrayList<String>,
        patient_appointment: ArrayList<String>,
        patient_od: ArrayList<String>,
        patient_os: ArrayList<String>,
        patient_add: ArrayList<String>,
        patient_pd: ArrayList<String>,
        patient_frame: ArrayList<String>,
        patient_lens: ArrayList<String>,
        patient_laboratory: ArrayList<String>,
        patient_price: ArrayList<String>
    ) {
        val cursor: Cursor? = myDB.readAllData()
        if (cursor != null) {
            if (cursor.count == 0) {
                Toast.makeText(this, "No data.", Toast.LENGTH_LONG).show()
            } else {
                while (cursor.moveToNext()) {
                    patient_name.add(cursor.getString(0))
                    patient_address.add(cursor.getString(1))
                    patient_age.add(cursor.getString(2))
                    patient_contact.add(cursor.getString(3))
                    patient_appointment.add(cursor.getString(4))
                    patient_od.add(cursor.getString(5))
                    patient_os.add(cursor.getString(6))
                    patient_add.add(cursor.getString(7))
                    patient_pd.add(cursor.getString(8))
                    patient_frame.add(cursor.getString(9))
                    patient_lens.add(cursor.getString(10))
                    patient_laboratory.add(cursor.getString(11))
                    patient_price.add(cursor.getString(12))
                }
            }
        }
        cursor?.close()
    }
}

