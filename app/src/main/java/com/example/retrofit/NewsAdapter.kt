package com.example.retrofit

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class NewsAdapter(val context :Context,val artical: List<Article> ): RecyclerView.Adapter<NewsAdapter.ArticalViewHolder>() {

    lateinit var mListner: onItemClickListner

    interface onItemClickListner{
        fun onItemClicked(position: Int)
    }

    fun setOnItemClickListner(listner: onItemClickListner){
        mListner =  listner
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticalViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.each_row, parent,false)
        return ArticalViewHolder(view, mListner)
    }



    override fun onBindViewHolder(holder: ArticalViewHolder, position: Int) {
        var artical = artical[position]
        holder.newsTitle.text = artical.title
        holder.newsDescription.text = artical.description
        Glide.with(context).load(artical.urlToImage).into(holder.newsImage)


        //For testing purpose, this working fine.
//        holder.itemView.setOnClickListener(View.OnClickListener {
//            Toast.makeText(it.context ,artical.title,Toast.LENGTH_LONG).show()
//        })
    }



    override fun getItemCount(): Int {
        return artical.size
    }



    class ArticalViewHolder(itemView: View, listner: onItemClickListner): RecyclerView.ViewHolder(itemView) {
        var newsImage = itemView.findViewById<ImageView>(R.id.newsImage)
        var newsTitle = itemView.findViewById<TextView>(R.id.newsTitle)
        var newsDescription = itemView.findViewById<TextView>(R.id.newsDescription)

        //new
        init {
            itemView.setOnClickListener {
                listner.onItemClicked(adapterPosition)
            }

        }

    }
}