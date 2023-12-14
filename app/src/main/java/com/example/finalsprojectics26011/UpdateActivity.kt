package com.example.finalsprojectics26011

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class UpdateActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        val btnHome = findViewById<ImageButton>(R.id.btnHome)
        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val btnDelete = findViewById<ImageButton>(R.id.btnDelete)
        btnDelete.setOnClickListener {
            confirmDialog()
        }

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
            val etName = findViewById<TextView>(R.id.etName2)
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

        // Getting updated data from TextInputEditText fields
/*
        val updatedName = findViewById<TextInputEditText>(R.id.etName2).text.toString()
*/
        val updatedAddress = findViewById<TextInputEditText>(R.id.etAddress2).text.toString()
        val updatedAge = findViewById<TextInputEditText>(R.id.etAge2).text.toString()
        val updatedContact = findViewById<TextInputEditText>(R.id.etContact2).text.toString()
        val updatedAppointment = findViewById<TextInputEditText>(R.id.etAppointment2).text.toString()
        val updatedOD = findViewById<TextInputEditText>(R.id.etOD2).text.toString()
        val updatedOS = findViewById<TextInputEditText>(R.id.etOS2).text.toString()
        val updatedAdd = findViewById<TextInputEditText>(R.id.etAdd2).text.toString()
        val updatedPD = findViewById<TextInputEditText>(R.id.etPD2).text.toString()
        val updatedFrame = findViewById<TextInputEditText>(R.id.etFrame2).text.toString()
        val updatedLens = findViewById<TextInputEditText>(R.id.etLens2).text.toString()
        val updatedLaboratory = findViewById<TextInputEditText>(R.id.etLaboratory2).text.toString()
        val updatedPrice = findViewById<TextInputEditText>(R.id.etPrice2).text.toString()

        // Assuming you have a method in MyDatabaseHelper for updating records
        val isUpdated = intent.getStringExtra("name")?.let {
            myDB.updateData(
                it,  // Assuming "originalName" is the primary key
/*
                updatedName,
*/
                updatedAddress,
                updatedAge,
                updatedContact,
                updatedAppointment,
                updatedOD,
                updatedOS,
                updatedAdd,
                updatedPD,
                updatedFrame,
                updatedLens,
                updatedLaboratory,
                updatedPrice
            )
        }

        if (isUpdated == true) {
            Toast.makeText(this, "Record updated successfully", Toast.LENGTH_SHORT).show()

            val resultIntent = Intent()
            setResult(Activity.RESULT_OK, resultIntent)

            // Refresh MainActivity
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
        } else {
            Toast.makeText(this, "Failed to update record", Toast.LENGTH_SHORT).show()
        }

        finish()
    }

    fun confirmDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Delete ${intent.getStringExtra("name")} ?")
        builder.setMessage("Are you sure you want to delete this patient from the records?")
        builder.setPositiveButton("Yes") { _, _ ->
            val myDB = MyDatabaseHelper(this@UpdateActivity)
            intent.getStringExtra("name")?.let {
                myDB.deleteOneRow(name = it)
            }
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.create().show()
    }
}
