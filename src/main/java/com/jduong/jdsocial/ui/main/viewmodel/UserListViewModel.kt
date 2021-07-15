package com.jduong.jdsocial.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jduong.jdsocial.data.model.User
import com.jduong.jdsocial.data.room.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserListViewModel(private val userDao : UserDao) : ViewModel() {

    val userList : LiveData<List<User>> = userDao.getAll()

    fun delete(userIn : User) = viewModelScope.launch(Dispatchers.IO) {
        userDao.delete(userIn)
    }
}