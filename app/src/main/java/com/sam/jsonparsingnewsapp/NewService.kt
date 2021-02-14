package com.sam.jsonparsingnewsapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// http://newsapi.org/v2/everything?q=tesla&from=2021-01-14&sortBy=publishedAt&apiKey=API_KEY
//http://newsapi.org/v2/top-headlines?country=in&apiKey=API_KEY
const val BASE_URL = "http://newsapi.org/"
const val API_KEY = "2feae0cc3b534626b20a8eaee2b63a03"
interface  NewsInterface{
    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadline(@Query("country")country: String, @Query("page")page: Int) : Call<News>
}

object NewsService{
    val newsInstance: NewsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}