package com.jduong.jdsocial.data.room

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jduong.jdsocial.data.model.Post

interface PostDao {

    @Query("SELECT * FROM post")
    fun getAll(): LiveData<List<Post>>

    @Query("SELECT * FROM post WHERE postID = :id")
    suspend fun get(id: Long): Post

    @Insert
    suspend fun insert(postIn: Post): Long

    @Delete
    suspend fun delete(postIn: Post)

    @Update
    suspend fun update(postIn: Post)
}