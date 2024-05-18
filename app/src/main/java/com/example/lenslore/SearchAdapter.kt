package com.example.lenslore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SearchAdapter(private val searchList: MutableList<Account>, var context: Context) : RecyclerView.Adapter<SearchAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.search_card, parent, false)
        return SearchAdapter.MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SearchAdapter.MyViewHolder, position: Int) {
        val currentSearch = searchList[position]

        holder.searchProfileIcon.setImageResource(currentSearch.profilePic)
        holder.searchUsername.text = currentSearch.username
        holder.searchUniqueUsername.text = currentSearch.unique_username
    }

    override fun getItemCount(): Int {
        return searchList.size
    }

    class MyViewHolder (itemview : View) : RecyclerView.ViewHolder(itemview){
        val searchProfileIcon : ImageView =  itemView.findViewById(R.id.search_profile_icon)
        val searchUsername : TextView = itemView.findViewById(R.id.search_username)
        val searchUniqueUsername : TextView = itemView.findViewById(R.id.search_unique_name)
    }

}