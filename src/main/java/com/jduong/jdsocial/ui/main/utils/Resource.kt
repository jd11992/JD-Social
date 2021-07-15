package com.jduong.jdsocial.ui.main.utils


enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}

data class Resource<out T>(val status : Status, val data : T?, val message : String?){
    companion object {
        fun <T> successMessage(data: T?): Resource<T>{
            return Resource(Status.SUCCESS,data,null )
        }
        fun <T> errorMessage(msg : String, data: T?): Resource<T>{
            return Resource(Status.ERROR, data, msg)
        }
        fun <T> loadingMessage(data: T?): Resource<T>{
            return Resource(Status.LOADING, data, null)
        }
    }

}
