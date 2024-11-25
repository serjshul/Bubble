package com.serjshul.bubble.data.repository

import com.serjshul.bubble.data.local.ArticleLocalDataSource
import com.serjshul.bubble.data.model.Article
import com.serjshul.bubble.data.remote.ArticleRemoteDataSource
import javax.inject.Inject

class ArticleRepository @Inject constructor(
    private val articleLocalDataSource: ArticleLocalDataSource,
    private val articleRemoteDataSource: ArticleRemoteDataSource
) {
    fun setArticle(draft: Article.Draft) {

    }
}