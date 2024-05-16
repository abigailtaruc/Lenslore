package com.example.lenslore

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class ChatActivity : AppCompatActivity() {
    lateinit var chatRecycler: RecyclerView
    private lateinit var db: Database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chat)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        db = Database(this)

        var chat = Chat(1, 2, "oldest")
        db.insertData(chat)
        chat = Chat(1, 3, "old")
        db.insertData(chat)
        chat = Chat(1, 2, "latest")
        db.insertData(chat)
        chat = Chat(1, 3, "newest")
        db.insertData(chat)
        chat = Chat(3, 2, "fail")
        db.insertData(chat)

        chatRecycler = findViewById(R.id.chat_recycler)
        chatRecycler.adapter = ChatAdapter(db.readLastChat(1),this)
        chatRecycler.layoutManager = LinearLayoutManager(this)

    }
}