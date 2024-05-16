package com.example.lenslore

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpVerificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up_verification)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun backClicked(view: View) {
        //var db = Database(this)
        //var everyone = db.readData()
        //Toast.makeText(this, everyone.toString(), Toast.LENGTH_SHORT).show()

        finish()
    }

    fun nextClicked(view: View) {
        //var account = Account("testdatabase2", "acad7y", "test@test.com")
        //var db = Database(this)
        //db.insertData(account)
        startActivityForResult(Intent(this, HomeActivity::class.java),4)
    }
    /*
    fun nextClicked(view: View) {
        TODO("Insert account into db")
        //var account = Account("testdatabase", "acad", "test@test.com")
        //var db = Database(this)
        //db.insertData(account)
        Toast.makeText(this, "testing", Toast.LENGTH_SHORT).show()
        //startActivityForResult(Intent(this, HomeActivity::class.java),4)
    }
     */

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 4 && resultCode == 4) {
            setResult(4)
            finish()
        }
    }
}