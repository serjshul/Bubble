package com.serjshul.bubble.data.article

import com.serjshul.bubble.data.model.Response
import com.serjshul.bubble.data.model.collections.Article
import com.serjshul.bubble.data.model.subcollections.Type

interface ArticleDataSource {
    suspend fun setArticle(article: Article.Draft): Response<String>
    suspend fun setType(type: Type): Response<String>
}