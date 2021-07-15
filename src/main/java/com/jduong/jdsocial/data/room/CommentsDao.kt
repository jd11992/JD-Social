package com.jduong.jdsocial.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jduong.jdsocial.data.model.Comments

@Dao
interface CommentsDao {
    @Query("SELECT * FROM comments")
     fun getAll() : LiveData<List<Comments>>

    @Query("SELECT * FROM comments WHERE commentID = :id")
     suspend fun get(id : Int) : Comments

    @Insert
    suspend fun insert(commentsIn : Comments) : Long

    @Delete
    suspend fun delete(commentsIn : Comments)

    @Update
    suspend fun update(commentsIn : Comments)
}