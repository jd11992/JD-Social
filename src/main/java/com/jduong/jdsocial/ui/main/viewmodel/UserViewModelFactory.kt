package com.jduong.jdsocial.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jduong.jdsocial.data.room.UserDao
import java.lang.IllegalArgumentException

class UserViewModelFactory(private val userDao : UserDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserEntryViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return UserEntryViewModel(userDao) as T
        }else if (modelClass.isAssignableFrom(UserEntryViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return UserEntryViewModel(userDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}