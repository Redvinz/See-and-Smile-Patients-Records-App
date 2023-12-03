    package com.example.finalsprojectics26011

    import android.content.Intent
    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import android.widget.ImageButton
    import com.google.android.material.textfield.TextInputEditText

    class AddActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_add)

            val btnHome = findViewById<ImageButton>(R.id.btnHome)

            btnHome.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

            val etName = findViewById<TextInputEditText>(R.id.etName)
            val etAddress = findViewById<TextInputEditText>(R.id.etAddress)
            val etAge = findViewById<TextInputEditText>(R.id.etAge)
            val etContact = findViewById<TextInputEditText>(R.id.etContact)
            val etAppointment = findViewById<TextInputEditText>(R.id.etAppointment)
            val etOD = findViewById<TextInputEditText>(R.id.etOD)
            val etOS = findViewById<TextInputEditText>(R.id.etOS)
            val etAdd = findViewById<TextInputEditText>(R.id.etAdd)
            val etPD = findViewById<TextInputEditText>(R.id.etPD)
            val etFrame = findViewById<TextInputEditText>(R.id.etFrame)
            val etLens = findViewById<TextInputEditText>(R.id.etLens)
            val etLaboratory = findViewById<TextInputEditText>(R.id.etLaboratory)
            val etPrice = findViewById<TextInputEditText>(R.id.etPrice)

            val btnAdd = findViewById<ImageButton>(R.id.btnAdd)

            btnAdd.setOnClickListener {

                val myDB = MyDatabaseHelper(this)
                myDB.addRecord(
                    etName.getText().toString().trim(),
                    etAddress.getText().toString().trim(),
                    etAge.getText().toString().trim(),
                    etContact.getText().toString().trim(),
                    etAppointment.getText().toString().trim(),
                    etOD.getText().toString().trim(),
                    etOS.getText().toString().trim(),
                    etAdd.getText().toString().trim(),
                    etPD.getText().toString().trim(),
                    etFrame.getText().toString().trim(),
                    etLens.getText().toString().trim(),
                    etLaboratory.getText().toString().trim(),
                    etPrice.getText().toString().trim()
                )
            }

        }
    }