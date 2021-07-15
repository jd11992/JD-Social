package com.jduong.jdsocial.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.jduong.jdsocial.R
import com.jduong.jdsocial.data.model.Comments
import com.jduong.jdsocial.data.model.JsonPost
import com.jduong.jdsocial.data.model.Post
import com.jduong.jdsocial.databinding.PostAdapterBinding

class PostAdapter() : ListAdapter<Post, PostAdapter.MyViewHolder>(PostDiffCallback()){


    class MyViewHolder(private val binding: PostAdapterBinding) : RecyclerView.ViewHolder(binding.root){
        private var userIDview = binding.postUserID
        private var userPostview = binding.postPostID
        private var posts : Post? = null
        fun bind(postIn : Post){

            userIDview.text = postIn.userID.toString()
            userPostview.text = postIn.userPost

            this.posts = postIn
        }


    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        PostAdapterBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       //Update view if  array list is not empty
        holder.bind(getItem(position))
    }



}
class PostDiffCallback : DiffUtil.ItemCallback<Post>(){
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.postID == newItem.postID
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }

}