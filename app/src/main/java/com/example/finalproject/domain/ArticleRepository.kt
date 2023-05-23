package com.example.finalproject.domain

import com.example.finalproject.data.Article

interface ArticleRepository {
    suspend fun getArticles(limit: Int): List<Article>
}