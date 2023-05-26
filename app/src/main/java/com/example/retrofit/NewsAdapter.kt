package com.example.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide


class NewsAdapter(val context :Context,val artical: List<Article> ): RecyclerView.Adapter<NewsAdapter.ArticalViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticalViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.each_row, parent,false)
        return ArticalViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticalViewHolder, position: Int) {
        var artical = artical[position]
        holder.newsTitle.text = artical.title
        holder.newsDescription.text = artical.description
        Glide.with(context).load(artical.urlToImage).into(holder.newsImage)
    }

    override fun getItemCount(): Int {
        return artical.size
    }



    class ArticalViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var newsImage = itemView.findViewById<ImageView>(R.id.newsImage)
        var newsTitle = itemView.findViewById<TextView>(R.id.newsTitle)
        var newsDescription = itemView.findViewById<TextView>(R.id.newsDescription)
    }
}