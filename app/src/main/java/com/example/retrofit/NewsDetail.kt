package com.example.retrofit

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


class NewsDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
//        Toast.makeText(this ,"testing",Toast.LENGTH_LONG).show()
//        val intent = intent

//        var newTitle = intent.getStringExtra("nTitle")
//        Toast.makeText(this ,newTitle,Toast.LENGTH_LONG).show()
//        Log.d("second screen",newTitle.toString())

        //Getting the data from previous activity through intent
//        val newsImgUrl = intent.getStringExtra("newsImgUrl")
//        val newsTitleInt = intent.getStringExtra("newsTitle")
//        val newsDescriptionInt = intent.getStringExtra("newsDescription")
//
//        val newsImg = findViewById<ImageView>(R.id.newsImage)
//        val tvNewsTitle = findViewById<TextView>(R.id.newsTitle)
//        val tvNewsDescription = findViewById<TextView>(R.id.newsDescription)
//
//
//        //Setting the values.
//        Glide.with(this).load(newsImgUrl).into(newsImg)
//        tvNewsTitle.text = newsTitleInt.toString()
//        tvNewsDescription.text = newsDescriptionInt.toString()

    }
}