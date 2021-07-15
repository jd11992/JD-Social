package com.jduong.jdsocial.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Post(@PrimaryKey val postID: Int,
                val userPost : String,
                val userID : Int)
