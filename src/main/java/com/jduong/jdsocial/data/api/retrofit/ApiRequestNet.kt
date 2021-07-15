package com.jduong.jdsocial.data.api.retrofit


import com.jduong.jdsocial.data.model.JsonPost
import okhttp3.Response
import retrofit2.Call
import retrofit2.http.*

interface ApiRequestNet {

    @FormUrlEncoded
    @GET("profile")
    suspend fun profiles(@Field("profile")profile:Int?): Response?

    @FormUrlEncoded
    @GET("post")
    suspend fun posts(@Field("post")posts:Int?):Response?


    @GET("jd11992/jd_social/posts")
    fun getPostsList() : Call<List<JsonPost>>

    @FormUrlEncoded
    @GET("comments")
    suspend fun comments(@Field("comments")comments:Int?):Response?

    @FormUrlEncoded
    @GET("album")
    suspend fun albums(@Field("album")album:Int?):Response?

}