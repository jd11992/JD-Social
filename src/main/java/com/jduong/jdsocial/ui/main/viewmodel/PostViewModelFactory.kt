package com.jduong.jdsocial.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.jduong.jdsocial.data.room.PostDao
import java.lang.IllegalArgumentException

class PostViewModelFactory(private val postDao : PostDao): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostEntryViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return PostEntryViewModel(postDao) as T
        }else if (modelClass.isAssignableFrom(PostEntryViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return PostEntryViewModel(postDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}