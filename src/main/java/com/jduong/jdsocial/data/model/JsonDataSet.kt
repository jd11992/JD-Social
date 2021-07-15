package com.jduong.jdsocial.data.model

import com.google.gson.annotations.SerializedName

data class JsonDataSet (@SerializedName("post")val postList : List<JsonPost>) {

}