package com.jduong.jdsocial.data.api.retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitFactory {
    val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    val client: OkHttpClient = OkHttpClient.Builder().apply {
        this.addInterceptor(interceptor)
        this.connectTimeout(120, TimeUnit.SECONDS)
        this.readTimeout(120, TimeUnit.SECONDS)
        this.writeTimeout(90, TimeUnit.SECONDS)
    }.build()

    var gson = GsonBuilder().setLenient().create()

    fun retrofit(baseUrl: String): Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

}