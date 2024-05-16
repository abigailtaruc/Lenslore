package com.example.lenslore

import android.content.Context
import android.opengl.Visibility
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class PostAdapter(private val postList: MutableList<Post>, var context : Context) : RecyclerView.Adapter<PostAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.post_card, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val db = Database (context)
        //val account = method that return Account
        val currentPost = postList[position]
        val currentAccount = db.readAccount(currentPost.accountID)
        holder.profilePic.setImageResource(currentAccount.profilePic);
        holder.username.text = currentAccount.username
        holder.uniqueUsername.text = currentAccount.unique_username
        holder.deleteIcon.setTag(currentPost.postId)
        holder.reportIcon.setTag(currentPost.postId)
        if (currentAccount.accountId == 2){
            holder.deleteIcon.visibility = View.VISIBLE
            holder.reportIcon.visibility = View.GONE
        }
        else{
            holder.deleteIcon.visibility = View.GONE
            holder.reportIcon.visibility = View.VISIBLE
        }
        holder.commentIcon.setTag(currentPost.postId)
        holder.likeIcon.setTag(currentPost.postId)
        holder.postTimestamp.text = currentPost.postTimestamp
        holder.caption.text = currentPost.caption
        holder.picture.setImageResource(currentPost.picture);
        holder.commentCount.text = db.readCommentCount(currentPost.postId).toString()
        holder.likeCount.text = db.readLikeCount(currentPost.postId).toString()
    }

    class MyViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview){
        val profilePic : ImageView = itemView.findViewById(R.id.profile_icon)
        val username : TextView = itemView.findViewById(R.id.username)
        val uniqueUsername : TextView = itemView.findViewById(R.id.unique_name)
        val deleteIcon : ImageView = itemView.findViewById(R.id.delete_icon)
        val reportIcon : ImageView = itemView.findViewById(R.id.report_icon)
        val postTimestamp : TextView = itemView.findViewById(R.id.post_timestamp)
        val caption: TextView = itemView.findViewById(R.id.caption)
        val picture : ImageView = itemView.findViewById(R.id.picture)
        val commentIcon : ImageView = itemView.findViewById(R.id.comment_icon)
        val commentCount : TextView = itemView.findViewById(R.id.comment_count)
        val likeIcon : ImageView = itemView.findViewById(R.id.like_icon)
        val likeCount : TextView = itemView.findViewById(R.id.like_count)
    }
}