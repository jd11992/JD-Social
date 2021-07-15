package com.jduong.jdsocial.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jduong.jdsocial.data.model.Post

@Dao
interface PostDao {

    @Query("SELECT * FROM post")
    fun getAll(): LiveData<List<Post>>

    @Query("SELECT * FROM post WHERE postID = :id")
    suspend fun get(id: Int): Post

    @Insert
    suspend fun insert(postIn: Post): Long

    @Delete
    suspend fun delete(postIn: Post)

    @Update
    suspend fun update(postIn: Post)
}