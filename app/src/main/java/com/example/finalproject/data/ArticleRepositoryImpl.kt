package com.example.finalproject.data

import com.example.finalproject.domain.ArticleRepository

class ArticleRepositoryImpl(private val apiService: ApiService) : ArticleRepository {
    override suspend fun getArticles(limit: Int): List<Article> {
        return apiService.getArticles(limit).results
    }
}