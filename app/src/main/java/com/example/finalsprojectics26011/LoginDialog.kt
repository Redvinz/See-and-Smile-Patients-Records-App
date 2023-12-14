package com.example.finalsprojectics26011

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class LoginDialog(context: Context, private val onLoginListener: OnLoginListener) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_login)

        val loginButton = findViewById<Button>(R.id.loginButton)
        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val errorTextView = findViewById<TextView>(R.id.errorTextView)
        val cancelButton = findViewById<Button>(R.id.cancelButton)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username == "admin" && password == "password123") {
                onLoginListener.onLoginSuccess()
                dismiss()

            } else {
                errorTextView.text = "Invalid credentials. Please try again."
            }
        }

        cancelButton.setOnClickListener {
            dismiss()
        }
    }
}

interface OnLoginListener {
    fun onLoginSuccess()

}