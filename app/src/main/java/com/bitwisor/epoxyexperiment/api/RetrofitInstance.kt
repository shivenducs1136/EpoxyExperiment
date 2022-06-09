package com.bitwisor.epoxyexperiment.api

import com.bitwisor.epoxyexperiment.Constants.MyConst
import com.bitwisor.epoxyexperiment.Interface.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(MyConst.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: ApiInterface by lazy{
        retrofit.create(ApiInterface::class.java)
    }
}