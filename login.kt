package com.example.onestop

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {

    companion object {
        const val SHARED_PREFS = "shared_prefs"
        const val EMAIL_KEY = "email_key"
        const val PASSWORD_KEY = "password_key"
    }

    private lateinit var sharedpreferences: SharedPreferences
    private var email: String? = null
    private var password: String? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailEdt = findViewById<EditText>(R.id.username)
        val passwordEdt = findViewById<EditText>(R.id.Password) // Ensure the ID is correct
        val loginBtn = findViewById<Button>(R.id.loginButton)

        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)

        email = sharedpreferences.getString(EMAIL_KEY, null)
        password = sharedpreferences.getString(PASSWORD_KEY, null)

        loginBtn.setOnClickListener {
            if (TextUtils.isEmpty(emailEdt.text.toString()) || TextUtils.isEmpty(passwordEdt.text.toString())) {
                Toast.makeText(this, "Please Enter Email and Password", Toast.LENGTH_SHORT).show()
            } else {
                val editor = sharedpreferences.edit()
                editor.putString(EMAIL_KEY, emailEdt.text.toString())
                editor.putString(PASSWORD_KEY, passwordEdt.text.toString())
                editor.apply()

                val i = Intent(this@Login, MainActivity2::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (email != null && password != null) {
            val i = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish() // Ensure the current activity is finished
        }
    }
}

