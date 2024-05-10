package com.example.lenslore

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun backClicked(view: View) {
        finish();
    }

    fun signUpClicked(view: View) {
        if (true){ //filled correctly
            startActivityForResult(Intent(this, SignUpVerificationActivity::class.java),3)
        }
        else{
            val errorMsg: TextView = findViewById(R.id.error);
            errorMsg.visibility = View.VISIBLE;
            //show error
        }
    }

    fun logInClicked(view: View) {
        startActivity(Intent(this, LogInActivity::class.java))
        finish()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 3 && resultCode == 4) {
            finish()
        }
    }
}