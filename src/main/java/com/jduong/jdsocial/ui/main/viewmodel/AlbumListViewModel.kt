package com.jduong.jdsocial.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jduong.jdsocial.data.model.Album
import com.jduong.jdsocial.data.room.AlbumDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AlbumListViewModel(private val albumDao : AlbumDao) : ViewModel() {
    val albumList : LiveData<List<Album>> = albumDao.getAll()

    fun delete(albumIn : Album) = viewModelScope.launch(Dispatchers.IO){
        albumDao.delete(albumIn)
    }
}