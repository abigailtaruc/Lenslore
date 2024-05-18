package com.example.lenslore

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchActivity : AppCompatActivity() {
    lateinit var searchRecycler: RecyclerView
    private lateinit var db: Database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        db = Database(this)
        Toast.makeText(this, db.readMultiAccount().toString(), Toast.LENGTH_SHORT).show()
        //searchRecycler = findViewById(R.id.search_recycler)
        //searchRecycler.adapter = SearchAdapter(db.readMultiAccount(),this)
        //searchRecycler.layoutManager = LinearLayoutManager(this)
    }

    fun searchAcc(view: View) {}
}