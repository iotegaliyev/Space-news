package com.example.finalproject.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.domain.GetArticlesUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ArticleAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val articleRepository = DataModule.provideArticleRepository()
        val getArticlesUseCase = GetArticlesUseCase(articleRepository)
        viewModel = MainViewModel(getArticlesUseCase)

        viewModel.articles.observe(this, Observer { articles ->
            adapter = ArticleAdapter(articles)
            recyclerView.adapter = adapter
        })

        viewModel.error.observe(this, Observer { errorMessage ->
            Log.e("MainActivity", errorMessage)
            // Display error message to the user
        })

        fetchData()
    }

    private fun fetchData() {
        viewModel.getArticles(100)
    }
}