package com.example.finalproject.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.data.Article
import com.example.finalproject.domain.GetArticlesUseCase
import kotlinx.coroutines.launch

class MainViewModel(private val getArticlesUseCase: GetArticlesUseCase) : ViewModel() {

    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> get() = _articles

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun getArticles(limit: Int) {
        viewModelScope.launch {
            try {
                val result = getArticlesUseCase.execute(limit)
                _articles.value = result
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error fetching articles", e)
                _error.value = "Error fetching articles: ${e.message}"
            }
        }
    }
}
