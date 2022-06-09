package com.bitwisor.epoxyexperiment.Interface


import com.bitwisor.epoxyexperiment.DataClass.NewsAPIdata
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("everything")
    suspend fun getNews(
        @Query("q") q:String,
        @Query("apiKey") apikey:String
    ):NewsAPIdata
}