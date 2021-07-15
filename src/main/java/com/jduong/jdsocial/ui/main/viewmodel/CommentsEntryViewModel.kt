package com.jduong.jdsocial.ui.main.viewmodel


import android.app.Notification
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.jduong.jdsocial.data.model.Comments
import com.jduong.jdsocial.data.room.CommentsDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CommentsEntryViewModel(private val commentsDao : CommentsDao) : ViewModel() {

    private var commentsLiveData : LiveData<Comments>? = null

    fun get(id : Int) : LiveData<Comments> {
        return commentsLiveData ?: liveData {
            emit(commentsDao.get(id))

        }.also{
            commentsLiveData = it
        }
    }


    fun addData( commentID : Int,  comment : String,  CpostID: Int,userID : Int, setupNotification: (Int) -> Unit ){
        val comments = Comments(commentID, comment,  CpostID, userID)

        CoroutineScope(Dispatchers.IO).launch {
            val actualID = commentID

            if (commentID > 0){
                update(comments)
            } else{
               insert(comments)
            }
            setupNotification(actualID)
        }

    }


    private suspend fun insert(comment : Comments) = commentsDao.insert(comment)

    private fun update(commentIn : Comments) = viewModelScope.launch(Dispatchers.IO){
      commentsDao.update(commentIn)
    }



}