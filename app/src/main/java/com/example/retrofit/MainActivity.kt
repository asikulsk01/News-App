package com.example.retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var adapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var count = 1

        getNews("in", count)

        val btnNext = findViewById<Button>(R.id.btnNext)
        btnNext.setOnClickListener {
            count += 1
            getNews("in", count)
        }

    }
//



    private fun getNews(country: String, page: Int) {

        val news = NewsService.newsInstance.getHeadLines(country,page)

        news.enqueue(object : Callback<News>{

            //For successfully API response
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if (news != null){
                    Log.d("MyTag",news.toString())

                    //populate the data into the recyclerview
                    adapter = NewsAdapter(this@MainActivity,news.articles)
                    var newsRecyclerView = findViewById<RecyclerView>(R.id.newsRecyclerView)
                    newsRecyclerView.adapter = adapter
                    newsRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

                    //new
                    adapter.setOnItemClickListner(object : NewsAdapter.onItemClickListner{
                        override fun onItemClicked(position: Int) {

                            val artical: List<Article> = news.articles
                            var getArticle = artical[position]
                            Toast.makeText(this@MainActivity,getArticle.title, Toast.LENGTH_SHORT).show()

////                            //now send the artical to the next page.
//
//                            val intent = Intent(this@MainActivity, NewsDetail::class.java)
//                            intent.putExtra("nTitle",getArticle.title)
//                            intent.putExtra("nDesc", getArticle.description)
//                            intent.putExtra("nImg", getArticle.urlToImage)
//                            startActivity(intent)
//
//                            Toast.makeText(this@MainActivity,"done", Toast.LENGTH_SHORT).show()
                        }
                    })

                }else{
                    Log.d("MyTag", "No News found")
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("MyTag","Error in fetching news. Excepting: $t")
            }

        })
    }
}