package com.serjshul.bubble.data.article

import com.google.firebase.firestore.FirebaseFirestore
import com.serjshul.bubble.data.model.FirebaseCollections
import com.serjshul.bubble.data.model.Response
import com.serjshul.bubble.data.model.collections.Article
import com.serjshul.bubble.data.model.subcollections.Type
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ArticleRemoteDataSource @Inject constructor(
    private val firestore: FirebaseFirestore
) : ArticleDataSource {
    override suspend fun setArticle(article: Article.Draft): Response<String> {
        return try {
            try {
                setType(article.getTypeWithErrorsCheck())
            } catch (e: IllegalStateException) {
                // TODO: Log service
            }
            try {
                val tags = article.getTagsWithErrorsCheck()
            } catch (e: IllegalStateException) {
                // TODO: Log service
            }

            val document = article.toDoc()
            try {
                val content = article.getContentWithErrorsCheck()
            } catch (e: IllegalStateException) {
                // TODO: Log service
            }

            val result = firestore
                .collection(FirebaseCollections.ARTICLES)
                .add(article)
                .await()
            Response.Success(result.id)
        } catch(e: Exception) {
            Response.Failure(e)
        }
    }

    override suspend fun setType(type: Type): Response<String> {
        firestore
            .collection(FirebaseCollections.TYPES)
            .document(type.id!!)
            .get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    // TODO: Документ существует
                } else {
                    // TODO: Документ не существует
                }
            }
            .addOnFailureListener { e ->
                // TODO: e.message
            }
        return Response.Success("")
    }
}