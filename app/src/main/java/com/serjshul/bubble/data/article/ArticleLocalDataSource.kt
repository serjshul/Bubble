package com.serjshul.bubble.data.article

import com.serjshul.bubble.data.model.Response
import com.serjshul.bubble.data.model.collections.Article
import com.serjshul.bubble.data.model.subcollections.Type
import javax.inject.Inject

class ArticleLocalDataSource @Inject constructor() : ArticleDataSource {
    override suspend fun setArticle(article: Article.Draft): Response<String> {
        TODO("Not yet implemented")
    }

    override suspend fun setType(type: Type): Response<String> {
        TODO("Not yet implemented")
    }
}