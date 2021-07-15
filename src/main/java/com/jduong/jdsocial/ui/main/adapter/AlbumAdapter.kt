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
import com.jduong.jdsocial.data.model.Album
import com.jduong.jdsocial.data.model.Comments
import com.jduong.jdsocial.data.model.User
import com.jduong.jdsocial.databinding.UserAlbumViewBinding

class AlbumAdapter() : ListAdapter<Album, AlbumAdapter.MyViewHolder>(AlbumDiffCallback()){

    class MyViewHolder(private val binding: UserAlbumViewBinding) : RecyclerView.ViewHolder(binding.root){
    private var imageHolder = binding.idImageText
      private var currentImage : Album? = null
        fun bind(albumIn : Album){
            val imageDescription : String = albumIn.imageDesc
            val imageURL : String = albumIn.imageURL
            imageHolder.text = imageDescription

            this.currentImage = albumIn
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        UserAlbumViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //Get position
        holder.bind(getItem(position))
    }

}
class AlbumDiffCallback : DiffUtil.ItemCallback<Album>(){
    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
       return oldItem.albumID == newItem.albumID
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem == newItem
    }

}