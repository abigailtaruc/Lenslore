package com.example.lenslore

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_log_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun backClicked(view: View) {
        finish();
    }

    fun forgetClicked(view: View) {
        startActivity(Intent(this, PasswordRecoveryActivity::class.java))
    }

    fun logInClicked(view: View) {
        if (true){ //if correct username and password
            startActivityForResult(Intent(this, HomeActivity::class.java), 5)
        }
        else{
            val errorMsg: TextView = findViewById(R.id.error);
            errorMsg.visibility = View.VISIBLE;
            //show error
        }
    }

    fun signUpClicked(view: View) {
        startActivity(Intent(this, SignUpActivity::class.java))
        finish()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 5 && resultCode == 4) {
            finish()
        }
    }
}