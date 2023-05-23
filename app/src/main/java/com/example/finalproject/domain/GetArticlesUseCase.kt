package com.example.finalproject.domain

import com.example.finalproject.data.Article

class GetArticlesUseCase(private val articleRepository: ArticleRepository) {
    suspend fun execute(limit: Int): List<Article> {
        return articleRepository.getArticles(limit)
    }
}