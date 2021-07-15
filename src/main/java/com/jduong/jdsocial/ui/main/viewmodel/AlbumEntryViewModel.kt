package com.jduong.jdsocial.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.jduong.jdsocial.data.model.Album
import com.jduong.jdsocial.data.room.AlbumDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AlbumEntryViewModel(private val albumDao: AlbumDao) : ViewModel() {

    private var albumLiveData : LiveData<Album>? = null

    fun get(id : Int) : LiveData<Album>{
        return albumLiveData ?: liveData {
            emit(albumDao.get(id))
        }.also {
            albumLiveData = it
        }
    }

    fun addData( userID : Int, albumID : Int, imageURL : String, imageDesc : String,setupNotification: (Int) -> Unit ){
        val albumIn = Album(userID, albumID, imageURL, imageDesc)
        val actualID = userID
        CoroutineScope(Dispatchers.IO).launch{

            if (albumID > 0){
                update(albumIn)
            }else{
                insert(albumIn)
            }
            setupNotification(actualID)
        }

    }

    private suspend fun  insert(albumIn : Album) = albumDao.insert(albumIn)

    private fun update(albumIn : Album) = viewModelScope.launch(Dispatchers.IO){
        albumDao.update(albumIn)
    }

}