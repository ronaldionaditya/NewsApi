package com.mobile.newsapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobile.newsapi.ArticlesItem
import com.mobile.newsapi.R

class NewsAdapter(var articles: List<ArticlesItem?>?) : RecyclerView.Adapter<NewsAdapter.NewsHolder>() {
    class NewsHolder(itemView : View) : RecyclerView.ViewHolder(itemView)  {

        val orang = itemView.findViewById<TextView>(R.id.itemAuthor)
        val judul = itemView.findViewById<TextView>(R.id.itemTitle)
        val gambar = itemView.findViewById<ImageView>(R.id.image)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        return NewsHolder(view)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val item = articles?.get(position)
        holder.orang.text = item?.author
        holder.judul.text = item?.title

        Glide.with(holder.itemView.context)
            .load(articles?.get(position)?.urlToImage)
            .into(holder.gambar)
    }

    override fun getItemCount(): Int = articles?.size?:0
}