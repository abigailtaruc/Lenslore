package com.example.lenslore

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.imageview.ShapeableImageView

class PostAdapter(private val accountList : ArrayList<Account>) : RecyclerView.Adapter<PostAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.post_card, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return accountList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = accountList[position]
        holder.profilePic.setImageResource(currentItem.profilePic);
        holder.username.text = currentItem.username
        holder.uniqueUsername.text = currentItem.unique_username
    }

    class MyViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview){
        val profilePic : ImageView = itemView.findViewById(R.id.profile_icon)
        val username : TextView = itemView.findViewById(R.id.username)
        val uniqueUsername : TextView = itemView.findViewById(R.id.unique_name)
    }

}