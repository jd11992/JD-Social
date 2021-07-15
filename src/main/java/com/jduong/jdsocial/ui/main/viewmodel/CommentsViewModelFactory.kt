package com.jduong.jdsocial.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jduong.jdsocial.data.room.CommentsDao
import java.lang.IllegalArgumentException

class CommentsViewModelFactory (private val commentDao : CommentsDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CommentsEntryViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return CommentsEntryViewModel(commentDao) as T
        }else if (modelClass.isAssignableFrom(CommentsEntryViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return CommentsEntryViewModel(commentDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}