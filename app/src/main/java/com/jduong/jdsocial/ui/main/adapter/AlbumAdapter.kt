package com.jduong.jdsocial.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jduong.jdsocial.R

class AlbumAdapter(val mContext : Context, val imageList : ArrayList<>) :
    RecyclerView.Adapter<AlbumAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.user_album_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //Display a text and image if they are available
       if(!imageList.isEmpty()){
           val item = imageList.get(position)

       }
    }

    override fun getItemCount(): Int {
     return imageList.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val textNImage : TextView = view.findViewById(R.id.id_ImageText)
    }

}