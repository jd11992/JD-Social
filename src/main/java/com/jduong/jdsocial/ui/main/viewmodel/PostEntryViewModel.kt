package com.jduong.jdsocial.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.jduong.jdsocial.data.model.Comments
import com.jduong.jdsocial.data.model.Post
import com.jduong.jdsocial.data.room.PostDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostEntryViewModel(private val postDao : PostDao) : ViewModel() {

    private var postLiveData : LiveData<Post>? = null

    fun get(id : Int) : LiveData<Post>{
        return postLiveData ?: liveData {
            emit(postDao.get(id))
        }.also {
            postLiveData = it
        }
    }

    fun addData(id : Int, postIn : String, userID : Int){
    val post = Post(id, postIn,userID)
        CoroutineScope(Dispatchers.IO).launch{

            if (id > 0){
                update(post)
            }else{
                insert(post)
            }

        }

    }

    private suspend fun insert(postIn : Post) = postDao.insert(postIn)

    private fun update(postIn : Post) = viewModelScope.launch(Dispatchers.IO){
        postDao.update(postIn)
    }

}