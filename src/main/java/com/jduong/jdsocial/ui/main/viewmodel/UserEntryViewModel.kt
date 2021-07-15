package com.jduong.jdsocial.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.jduong.jdsocial.data.model.User
import com.jduong.jdsocial.data.room.UserDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserEntryViewModel(private val userDao : UserDao) : ViewModel() {
    private var userLiveData : LiveData<User>? = null

    fun get(userID : Int) :LiveData<User>{
        return userLiveData?: liveData {
            emit(userDao.get(userID))
        }.also {
            userLiveData = it
        }
    }


    fun addData(userID: Int, userName: String, setupNotification: (Int) -> Unit){
        val userData = User(userID, userName)
        CoroutineScope(Dispatchers.IO).launch {
            val actualID = userID

            if (userID > 0){
                update(userData)
            }else{
                insert(userData)
            }
            setupNotification(actualID)
        }
    }

    private suspend fun insert(userIn : User) = userDao.insert(userIn)

    private fun update(userIn: User) = viewModelScope.launch(Dispatchers.IO){
        userDao.update(userIn)
    }
}