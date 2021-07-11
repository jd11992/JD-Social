package com.jduong.jdsocial.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jduong.jdsocial.R
import com.jduong.jdsocial.data.model.Comments

class CommentsAdapter( val commentsList : ArrayList<Comments>) :
    RecyclerView.Adapter<CommentsAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
     val inflater = LayoutInflater.from(parent.context)
      val view = inflater.inflate(R.layout.comments_adapter, parent, false)
      return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if(!commentsList.isEmpty()){
            val comments = commentsList.get(position)
            val commentID : Int = comments.commentID
            val commentString : String = comments.comment

            holder.userLabel.text = commentID.toString()
            holder.userComments.text = commentString

        }
    }

    override fun getItemCount(): Int {
        return commentsList.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val userLabel : TextView = view.findViewById(R.id.comm_userID)
        val userComments : TextView = view.findViewById(R.id.comm_userComments)
    }
}