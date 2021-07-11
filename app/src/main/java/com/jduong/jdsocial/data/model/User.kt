package com.jduong.jdsocial.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(@PrimaryKey val userID: Int,
                val userName: String)
