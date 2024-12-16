package com.serjshul.bubble.data.article

import com.serjshul.bubble.data.response.Response
import com.serjshul.bubble.data.model.collections.Article
import com.serjshul.bubble.data.model.subcollections.Type
import com.serjshul.bubble.services.LogService
import javax.inject.Inject

class ArticleLocalDataSource @Inject constructor(
    private val logService: LogService
) : ArticleDataSource {
    override suspend fun setArticle(article: Article.Draft): Response<String> {
        TODO("Not yet implemented")
    }

    override suspend fun checkTypeExistence(type: Type): Response<String> {
        TODO("Not yet implemented")
    }
}