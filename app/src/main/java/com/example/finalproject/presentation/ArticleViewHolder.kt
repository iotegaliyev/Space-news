package com.example.finalproject.presentation

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalproject.R
import com.example.finalproject.data.Article

class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val articleTitle: TextView = itemView.findViewById(R.id.article_title)
    private val articleImage: ImageView = itemView.findViewById(R.id.article_image)
    private val newsSite: TextView = itemView.findViewById(R.id.site)

    fun bind(article: Article) {
        articleTitle.text = article.title
        newsSite.text = article.news_site
        Glide.with(itemView).load(article.image_url).into(articleImage)
    }
}