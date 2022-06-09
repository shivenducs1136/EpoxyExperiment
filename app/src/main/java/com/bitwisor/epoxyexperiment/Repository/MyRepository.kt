package com.bitwisor.epoxyexperiment.Repository

import com.bitwisor.epoxyexperiment.Constants.MyConst
import com.bitwisor.epoxyexperiment.DataClass.NewsAPIdata
import com.bitwisor.epoxyexperiment.api.RetrofitInstance

class MyRepository {

    suspend fun getNews():NewsAPIdata{
        return RetrofitInstance.api.getNews("India",MyConst.API_KEY)
    }

}