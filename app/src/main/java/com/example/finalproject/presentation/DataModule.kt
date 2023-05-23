package com.example.finalproject.presentation

import com.example.finalproject.data.ApiService
import com.example.finalproject.data.ArticleRepositoryImpl
import com.example.finalproject.domain.ArticleRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataModule {
    private fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.spaceflightnewsapi.net/v4/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    fun provideArticleRepository(): ArticleRepository {
        val apiService = provideApiService()
        return ArticleRepositoryImpl(apiService)
    }
}