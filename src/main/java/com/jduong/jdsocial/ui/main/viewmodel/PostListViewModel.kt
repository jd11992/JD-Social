package com.jduong.jdsocial.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jduong.jdsocial.data.model.Post
import com.jduong.jdsocial.data.room.PostDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostListViewModel(private val postDao : PostDao) : ViewModel() {
    val postList : LiveData<List<Post>> = postDao.getAll()


    fun delete(postIn : Post) = viewModelScope.launch(Dispatchers.IO){
        postDao.delete(postIn)
    }
}