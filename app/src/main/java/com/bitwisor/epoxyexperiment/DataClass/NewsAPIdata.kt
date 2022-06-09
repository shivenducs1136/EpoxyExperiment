package com.bitwisor.epoxyexperiment.DataClass

data class NewsAPIdata(
    val articles: List<Article>? = null,
    val status: String? = null,
    val totalResults: Int? = null
)