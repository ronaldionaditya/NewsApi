package com.mobile.newsapi.network


import com.mobile.newsapi.ResponseServer
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    @GET("everything")

    fun getDataRest(
        @Query("q") keyword : String,
        @Query("from") from: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey: String,
    ):Call<ResponseServer>


}