package com.jduong.jdsocial.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

data class JsonPost(@SerializedName("postID") val postID: Int,@SerializedName("userPost") val userPost: String,@SerializedName("userID") val userID: Int, ) {
}