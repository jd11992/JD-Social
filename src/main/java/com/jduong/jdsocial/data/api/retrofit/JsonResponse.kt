package com.jduong.jdsocial.data.api.retrofit

import com.google.gson.annotations.SerializedName
import com.jduong.jdsocial.data.model.JsonPost

class JsonResponse {
    @SerializedName("titles")
    var titlesArray = ArrayList<JsonPost>()

}