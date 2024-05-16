package com.example.lenslore

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentAdapter(private val commentList: MutableList<Comment>, var context: Context) : RecyclerView.Adapter<CommentAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.comment_card, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return commentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val db = Database(context)
        val currentComment = commentList[position]
        val currentCommentAccount = db.readAccount(currentComment.accountId)
        holder.commentProfileIcon.setImageResource(currentCommentAccount.profilePic)
        holder.commentUsername.text = currentCommentAccount.username
        holder.commentUniqueUsername.text = currentCommentAccount.unique_username
        holder.commentDeleteIcon.setTag(currentComment.commentId)
        holder.commentReportIcon.setTag(currentComment.commentId)
        if (currentCommentAccount.accountId == 1){
            holder.commentReportIcon.visibility = View.GONE
            holder.commentDeleteIcon.visibility = View.VISIBLE
        }
        else{
            holder.commentReportIcon.visibility = View.VISIBLE
            holder.commentDeleteIcon.visibility = View.GONE
        }
        holder.comment.text = currentComment.commentContent
    }

    class MyViewHolder (itemview : View) : RecyclerView.ViewHolder(itemview){
        val commentProfileIcon : ImageView =  itemView.findViewById(R.id.comment_profile_icon)
        val commentUsername : TextView = itemView.findViewById(R.id.comment_username)
        val commentUniqueUsername : TextView = itemView.findViewById(R.id.comment_unique_name)
        val commentDeleteIcon : ImageView =  itemView.findViewById(R.id.comment_delete_icon)
        val commentReportIcon : ImageView =  itemView.findViewById(R.id.comment_report_icon)
        val comment : TextView = itemView.findViewById(R.id.comment)
    }
}