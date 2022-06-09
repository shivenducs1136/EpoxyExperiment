package com.bitwisor.epoxyexperiment.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bitwisor.epoxyexperiment.DataClass.NewsAPIdata
import com.bitwisor.epoxyexperiment.Repository.MyRepository
import kotlinx.coroutines.launch

class HomeFragmentViewModel:ViewModel() {
    val repo = MyRepository()

    val myresponse:MutableLiveData<NewsAPIdata> = MutableLiveData()

    fun getNews(){
        viewModelScope.launch {
            val response:NewsAPIdata = repo.getNews()
            myresponse.value = response
        }
    }

}