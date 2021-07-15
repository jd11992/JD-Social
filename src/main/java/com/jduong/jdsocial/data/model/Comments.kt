package com.jduong.jdsocial.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Comments(@PrimaryKey val commentID : Int,
                    val comment : String,
                    val postID : Int,
                    val userID : Int  )
