package com.jduong.jdsocial.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class CommentsViewModelFactory () : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CommentsEntryViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return CommentsEntryViewModel() as T
        }else if (modelClass.isAssignableFrom(CommentsEntryViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return CommentsEntryViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}