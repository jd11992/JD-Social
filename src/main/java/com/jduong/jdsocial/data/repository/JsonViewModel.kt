package com.jduong.jdsocial.data.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jduong.jdsocial.data.api.jsonURL
import com.jduong.jdsocial.data.api.retrofit.ApiFactory
import com.jduong.jdsocial.data.api.retrofit.ApiRequestNet
import com.jduong.jdsocial.data.api.retrofit.JsonResponse
import com.jduong.jdsocial.data.api.retrofit.RetrofitFactory
import com.jduong.jdsocial.data.model.JsonPost
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JsonViewModel() : ViewModel()  {

   val mFitService = ApiFactory.placeHolderApi

   fun getTitles() : List<JsonPost> {

       lateinit var getPost : List<JsonPost>
        val callservice = mFitService.getPostsList()



       callservice.enqueue(object : Callback<List<JsonPost>>{
           override fun onResponse(call: Call<List<JsonPost>>, response: Response<List<JsonPost>>) {

               if (response.code() == 200){
                   getPost = response.body()!!
               }



           }

           override fun onFailure(call: Call<List<JsonPost>>, t: Throwable) {

           }
       })
     /* viewModelScope.launch {


      }*/

      return getPost
   }


}

