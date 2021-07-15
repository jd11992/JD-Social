package com.jduong.jdsocial.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jduong.jdsocial.data.model.Album

@Dao
interface  AlbumDao {
    @Query("SELECT * FROM album")
    fun getAll(): LiveData<List<Album>>

    @Query("SELECT * FROM album WHERE userID = :userID")
    suspend fun get(userID : Int) : Album

    @Insert
     suspend fun insert(albumIn : Album) : Long

    @Delete
     suspend fun delete(albumIn : Album)

    @Update
     suspend fun update(albumIn: Album)


}