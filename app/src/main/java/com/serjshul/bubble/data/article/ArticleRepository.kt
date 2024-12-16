package com.serjshul.bubble.data.article

import com.serjshul.bubble.data.model.collections.Article
import com.serjshul.bubble.services.LogService
import javax.inject.Inject

class ArticleRepository @Inject constructor(
    private val logService: LogService,
    private val articleLocalDataSource: ArticleLocalDataSource,
    private val articleRemoteDataSource: ArticleRemoteDataSource
) {
    fun setArticle(draft: Article.Draft) {

    }
}