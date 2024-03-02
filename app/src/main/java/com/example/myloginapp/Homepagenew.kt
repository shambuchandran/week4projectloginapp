package com.example.myloginapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextClock
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Homepagenew : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_homepagenew)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val hmMessage = findViewById<TextView>(R.id.hmmessage)
        val hmUser = findViewById<TextView>(R.id.hmuser)
        val hmEmail = findViewById<TextView>(R.id.hmemail)
        val signOut = findViewById<Button>(R.id.hmsignout)
        val gotUserName = intent.getStringExtra("EXTRA_USERNAME")
        val message = "Hi $gotUserName, welcome back and hope you are having a wonderful day"
        hmMessage.text = message
        hmUser.text = gotUserName
        val emailId = "EMAIL ID: $gotUserName@mail.com"
        hmEmail.text = emailId

        signOut.setOnClickListener {
            val alertBox = AlertDialog.Builder(this)
            alertBox.setTitle("Sign out!!")
            alertBox.setMessage("Do you want to proceed?")
            alertBox.setIcon(R.drawable.baseline_add_alert_24)
            alertBox.setPositiveButton("Yes") { dialogInterface, which ->
                Intent(this, MainActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }
            alertBox.setNegativeButton("No") { dialogInterface, which ->
                return@setNegativeButton
            }
            val alertShow: AlertDialog = alertBox.create()
            alertShow.setCancelable(false)
            alertShow.show()
        }
        //for back pressed
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val alertBox = AlertDialog.Builder(this@Homepagenew)
                alertBox.setTitle("Sign out!!")
                alertBox.setMessage("Do you want to proceed?")
                alertBox.setIcon(R.drawable.baseline_add_alert_24)
                alertBox.setPositiveButton("Yes") { dialogInterface, which ->
                    Intent(this@Homepagenew, MainActivity::class.java).also {
                        startActivity(it)
                        finish()
                    }
                }
                alertBox.setNegativeButton("No") { dialogInterface, which ->
                    return@setNegativeButton
                }
                val alertShow: AlertDialog = alertBox.create()
                alertShow.setCancelable(false)
                alertShow.show()
            }
        })
        val hmClock = findViewById<TextClock>(R.id.textClock)
        hmClock.format12Hour = "hh:mm a"

    }
}