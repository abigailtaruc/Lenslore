package com.example.lenslore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(private val chatList: MutableList<Chat>, var context: Context) : RecyclerView.Adapter<ChatAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.chat_card, parent, false)
        return ChatAdapter.MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val db = Database(context)
        val currentChat = chatList[position]
        val currentAccount = db.readAccount(currentChat.accountId2)

        holder.chatProfileIcon.setImageResource(currentAccount.profilePic)
        holder.chatUsername.text = currentAccount.username
        holder.chatUniqueUsername.text = currentAccount.unique_username
        holder.chat.text = currentChat.chatContent
    }

    class MyViewHolder (itemview : View) : RecyclerView.ViewHolder(itemview){
        val chatProfileIcon : ImageView =  itemView.findViewById(R.id.chat_profile_icon)
        val chatUsername : TextView = itemView.findViewById(R.id.chat_username)
        val chatUniqueUsername : TextView = itemView.findViewById(R.id.chat_unique_name)
        val chat : TextView = itemView.findViewById(R.id.chat)
    }

}