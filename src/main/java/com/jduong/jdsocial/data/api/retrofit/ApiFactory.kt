package com.jduong.jdsocial.data.api.retrofit

import com.jduong.jdsocial.data.api.jsonURL

object ApiFactory {
    val placeHolderApi : ApiRequestNet = RetrofitFactory.retrofit(jsonURL.jsonURL).create(ApiRequestNet::class.java)
}