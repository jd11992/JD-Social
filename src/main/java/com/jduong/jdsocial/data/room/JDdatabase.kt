package com.jduong.jdsocial.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jduong.jdsocial.data.model.Album
import com.jduong.jdsocial.data.model.Comments
import com.jduong.jdsocial.data.model.Post
import com.jduong.jdsocial.data.model.User

@Database(entities =arrayOf(User::class, Post::class, Comments::class, Album:: class), version = 1)
abstract class JDdatabase : RoomDatabase()  {

    abstract fun userDao() : UserDao
    abstract fun postDao() : PostDao
    abstract fun commentsDao() : CommentsDao
    abstract fun albumDao() : AlbumDao

    companion object{
        @Volatile private var INSTANCE : JDdatabase? = null

        fun getDatabase(context : Context): JDdatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context, JDdatabase::class.java, "jd_database")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}