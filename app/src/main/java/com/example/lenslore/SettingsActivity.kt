package com.example.lenslore

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_settings)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find the log_out TextView
        val logOutTextView: TextView = findViewById(R.id.log_out)

        // Set a click listener to the log_out TextView
        logOutTextView.setOnClickListener {
            // Create an Intent to start MainActivity
            val intent = Intent(this, MainActivity::class.java)

            // Start the MainActivity
            startActivity(intent)

            // Finish the current activity (SettingsActivity)
            finish()
        }
    }
}
