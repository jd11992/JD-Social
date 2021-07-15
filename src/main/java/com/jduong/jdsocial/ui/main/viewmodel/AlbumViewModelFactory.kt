package com.jduong.jdsocial.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jduong.jdsocial.data.room.AlbumDao
import java.lang.IllegalArgumentException

class AlbumViewModelFactory(private val albumDao : AlbumDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlbumEntryViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return AlbumEntryViewModel(albumDao) as T
        }else if (modelClass.isAssignableFrom(AlbumEntryViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return AlbumEntryViewModel(albumDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}