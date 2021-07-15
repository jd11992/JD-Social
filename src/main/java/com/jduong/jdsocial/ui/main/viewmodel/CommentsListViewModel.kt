package com.jduong.jdsocial.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jduong.jdsocial.data.model.Comments
import com.jduong.jdsocial.data.room.CommentsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CommentsListViewModel(private val commentsDao : CommentsDao) : ViewModel() {

    val commentsList : LiveData<List<Comments>> = commentsDao.getAll()

    fun delete(commentIn : Comments) = viewModelScope.launch(Dispatchers.IO) {
        commentsDao.delete(commentIn)
    }

}