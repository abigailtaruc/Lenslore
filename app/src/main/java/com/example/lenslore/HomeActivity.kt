package com.example.lenslore

import android.content.Intent
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.view.WindowManager
import android.widget.RelativeLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeActivity : AppCompatActivity() {

    lateinit var postRecycler : RecyclerView
    lateinit var commentRecycler : RecyclerView
    lateinit var commentSection : RelativeLayout
    var lastComment : Int = 0
    private lateinit var db : Database


    override fun onCreate(savedInstanceState: Bundle?) {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE or WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        postRecycler = findViewById(R.id.post_recycler)
        commentRecycler = findViewById(R.id.comment_recycler)
        commentSection = findViewById(R.id.comment_section)

        db = Database(this)

        var account = Account(1,"test4", "password1", "test1@")
        //db.insertData(account)
        account = Account(2,"success", "password2", "test2@")
        //db.insertData(account)
        account = Account(3,"test6", "password3", "test3@")
        //db.insertData(account)

        var post = Post(2, R.drawable.test, "testcaption2", "10:00")
        //db.insertData(post)
        post = Post(3, R.drawable.mountain2, "testcaption3", "12:00")
        //db.insertData(post)
        post = Post(1, R.drawable.camera_icon, "testcaption1", "1:00")
        //db.insertData(post)

        var comment = Comment(1, 2, "a")
        db.insertData(comment)
        comment = Comment(1, 1, "aasd")
        db.insertData(comment)
        comment = Comment(2, 3, "aasd")
        db.insertData(comment)

        var like = Like(1, 2, 2)
        //db.insertData(like)
        like = Like(1, 2, 1)
        //db.insertData(like)
        like = Like(1, 1, 3)
        //db.insertData(like)
        postRecycler.adapter = PostAdapter(db.readPost(), this)
        postRecycler.layoutManager = LinearLayoutManager(this)


        commentRecycler.layoutManager = LinearLayoutManager(this)

        db.close()
    }

    fun signUpClicked(view: View) {
        setResult(4)
        finish()
    }

    fun deletePost(view: View) {
        val db = Database(this)
        db.deletePost(view.getTag().toString().toInt())
        postRecycler.adapter = PostAdapter(db.readPost(), this)
        db.close()
    }

    fun reportPost(view: View) {}
    fun deleteComment(view: View) {
        val db = Database(this)
        db.deleteComment(view.getTag().toString().toInt())
        commentRecycler.adapter = CommentAdapter(db.readComment(lastComment), this)
        db.close()
    }
    fun reportComment(view: View) {}
    fun closeComment(view: View) {
        commentSection.visibility = View.GONE
    }

    fun openComment(view: View) {
        lastComment = view.getTag().toString().toInt()
        commentRecycler.adapter = CommentAdapter(db.readComment(view.getTag().toString().toInt()), this)
        commentSection.visibility = View.VISIBLE

    }

    //stop crash when result is zero, find way to not refresh
    fun onUploadClicked(view: View?) {
        // Create an Intent to navigate to the UploadActivity
        val intent = Intent(this, UploadActivity::class.java)
        startActivity(intent) // Start the UploadActivity
    }

}