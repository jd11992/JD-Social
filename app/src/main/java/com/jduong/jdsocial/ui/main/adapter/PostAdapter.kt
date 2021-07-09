package com.jduong.jdsocial.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jduong.jdsocial.R

class PostAdapter(val mContext : Context, val postList : ArrayList<>) :
    RecyclerView.Adapter<PostAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.post_adapter, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       //Update view if  array list is not empty
        if (!postList.isEmpty()){
           val post = postList.get(position)

       }
    }

    override fun getItemCount(): Int {
        return postList.size
    }
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val userID : TextView = view.findViewById(R.id.post_userID)
        val userPost : TextView = view.findViewById(R.id.post_postID)
        val commRView : RecyclerView = view.findViewById(R.id.comment_Rview)
    }
}