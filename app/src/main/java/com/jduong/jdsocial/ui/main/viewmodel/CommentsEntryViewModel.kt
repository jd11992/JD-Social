package com.jduong.jdsocial.ui.main.viewmodel


import android.app.Notification
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.jduong.jdsocial.data.model.Comments
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CommentsEntryViewModel() : ViewModel() {

    private var commentsLiveData : LiveData<Comments>? = null
    private val CommentsList : ArrayList<Comments> = ArrayList()
    fun get(id : Int) : LiveData<Comments> {
        return commentsLiveData ?: liveData {
            if (!CommentsList.isEmpty()){
                for (position   in CommentsList){
                    val commentID : Int = position.commentID

                    if (commentID == id){
                        emit(position)
                        break
                    }
                }
            }

        }.also{
            commentsLiveData = it
        }
    }


    fun addData( commentID : Int,  comment : String,  CpostID: Int,userID : Int, setupNotification: (Int) -> Unit ){
        val comments = Comments(commentID, comment,  CpostID, userID)

        CoroutineScope(Dispatchers.IO).launch {


            if (commentID > 0){
                update(comments)
            } else{
                insert(comments)
            }
        }

    }


    private suspend fun insert(comment : Comments) = CommentsList.add(comment)

    private fun update(commentIn : Comments) = viewModelScope.launch(Dispatchers.IO){
        if (!CommentsList.isEmpty()){
         val commentPosition : Int = CommentsList.indexOf(commentIn)

            CommentsList[commentPosition] = commentIn
        }
    }



}