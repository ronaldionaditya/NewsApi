package com.mobile.newsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mobile.newsapi.adapter.NewsAdapter
import com.mobile.newsapi.network.NetworkClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NetworkClient.iniService().getDataRest(keyword = "movie", from = "2021-04-20", sortBy = "publishedAt", apiKey = "e34d7f63faef420b861e83bda168ba83")
                .enqueue(object : Callback<ResponseServer> {
                    override fun onResponse(
                            call: Call<ResponseServer>,
                            response: Response<ResponseServer>
                    ) {

                        Log.d("response server", response.message())

                        //check response server
                        if (response.isSuccessful) {

                            val stat = response.body()?.status

                            if (stat == "ok") {

                                val articles = response.body()!!.articles

                                showArticles(articles)

                            }
                        }

                    }

                    override fun onFailure(call: Call<ResponseServer>, t: Throwable) {
                        t.message?.let { Log.d("error server", it) }
                    }

                })

    }

    private fun showArticles(articles: List<ArticlesItem?>?) {

        var adapter = NewsAdapter(articles)
        listRestApi.adapter = adapter
    }
}