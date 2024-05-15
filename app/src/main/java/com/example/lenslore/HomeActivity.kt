package com.example.lenslore

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeActivity : AppCompatActivity() {

    private lateinit var postRecycler : RecyclerView
    private lateinit var postArrayList: ArrayList<Account>
    //lateinit var profileId : ArrayList<Int>
    lateinit var username : ArrayList<String>
    lateinit var uniqueUsername : ArrayList <String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Account(R.drawable.mountain, 1, "test", "test2", "test3", "test4")
        // = arrayListOf(R.drawable.mountain, R.drawable.phonecam, R.drawable.test)
        username = arrayListOf("test1", "test2", "test3")
        uniqueUsername = arrayListOf("@test1", "@test2", "@test3")

        postRecycler = findViewById(R.id.post_recycler)
        postRecycler.layoutManager = LinearLayoutManager(this)

        postArrayList = arrayListOf<Account>()
        //getUserData()
        postArrayList.add(Account(1, R.drawable.mountain, "test1", "@test1", "test1@", "just test 1"))
        postArrayList.add(Account(2, R.drawable.test, "test2", "@test2", "test2@", "just test 2"))
        postArrayList.add(Account(3, R.drawable.profile_icon, "test3", "@test3", "test3@", "just test 3"))
        postArrayList.add(Account(4, R.drawable.mountain2, "test4", "@test4", "test4@", "just test 4"))


        postRecycler.adapter = PostAdapter(postArrayList)


    }

    /*
    private fun getUserData() {
        for (i in profileId.indices){
            val post = Account(profileId[i], i, username[i], uniqueUsername[i], "email", "hello")
            postArrayList.add(post)
        }

        postRecycler.adapter = PostAdapter(postArrayList)
    }
    */


    fun signUpClicked(view: View) {
        setResult(4)
        finish()
    }

    fun onUploadClicked(view: View?) {
        // Create an Intent to navigate to the UploadActivity
        val intent = Intent(this, UploadActivity::class.java)
        startActivity(intent) // Start the UploadActivity
    }

}