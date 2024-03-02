package com.example.myloginapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val username = findViewById<EditText>(R.id.acemail)
        val userPassword = findViewById<EditText>(R.id.acpassword)
        val loginButton = findViewById<Button>(R.id.acbutton)
        val logoutButton = findViewById<FloatingActionButton>(R.id.acback)
        val savedUserName = "loginusername"
        val savedPassword = "123456789"

        loginButton.setOnClickListener {
            val enteredUserName = username.text.toString()
            val enteredPassword = userPassword.text.toString()
            if (enteredUserName != savedUserName) {
                Toast.makeText(this, "Username mismatch", Toast.LENGTH_LONG).show()
            } else if (enteredPassword != savedPassword) {
                Toast.makeText(this, "Wrong password", Toast.LENGTH_LONG).show()
            } else {
                Intent(this, Homepagenew::class.java).also {
                    it.putExtra("EXTRA_USERNAME", enteredUserName)
                    startActivity(it)
                    username.text.clear()
                    userPassword.text.clear()
                }
            }
        }
        logoutButton.setOnClickListener {
            finish()
        }


    }
}