package com.jduong.jdsocial.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jduong.jdsocial.R
import com.jduong.jdsocial.data.model.Comments
import com.jduong.jdsocial.databinding.CommentsAdapterBinding


class CommentsAdapter( ) :
    ListAdapter<Comments, CommentsAdapter.MyViewHolder>(CommentsDiffCallback()){

    class MyViewHolder(private val binding : CommentsAdapterBinding) : RecyclerView.ViewHolder(binding.root){
        private var userIDview = binding.commUserID
        private var userCommentview = binding.commUserComments
        private var currentComment : Comments? = null
        fun bind(commentIn : Comments){
            val userID = commentIn.userID
            val userComment = commentIn.comment

            userIDview.text = userID.toString()
            userCommentview.text = userComment
            this.currentComment = commentIn
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        CommentsAdapterBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }




}
class CommentsDiffCallback : DiffUtil.ItemCallback<Comments>(){
    override fun areItemsTheSame(oldItem: Comments, newItem: Comments): Boolean {
        return oldItem.commentID == newItem.commentID
    }

    override fun areContentsTheSame(oldItem: Comments, newItem: Comments): Boolean {
        return oldItem == newItem
    }

}