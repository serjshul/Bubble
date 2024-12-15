package com.serjshul.bubble.data.article

import com.serjshul.bubble.data.model.collections.Article
import javax.inject.Inject

class ArticleRepository @Inject constructor(
    private val articleLocalDataSource: ArticleLocalDataSource,
    private val articleRemoteDataSource: ArticleRemoteDataSource
) {
    fun setArticle(draft: Article.Draft) {

    }
}