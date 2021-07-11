package com.jduong.jdsocial.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jduong.jdsocial.data.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): LiveData<List<User>>

    @Query("SELECT * FROM user WHERE userID = :id")
    suspend fun get(id: Long): User

    @Insert
    suspend fun insert(user: User): Long

    @Delete
    suspend fun delete(user: User)

    @Update
    suspend fun update(user: User)

}