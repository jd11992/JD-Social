package com.jduong.jdsocial.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Album(@PrimaryKey val userID : Int,
                 val albumID : Int,
                 val imageURL : String,
                 val imageDesc : String   )
