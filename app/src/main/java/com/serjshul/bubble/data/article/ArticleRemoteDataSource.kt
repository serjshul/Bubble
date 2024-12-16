package com.serjshul.bubble.data.article

import com.google.firebase.firestore.FirebaseFirestore
import com.serjshul.bubble.data.Collections
import com.serjshul.bubble.data.DataTypes
import com.serjshul.bubble.data.Sources
import com.serjshul.bubble.data.response.Response
import com.serjshul.bubble.data.model.collections.Article
import com.serjshul.bubble.data.model.subcollections.Type
import com.serjshul.bubble.data.response.Failure
import com.serjshul.bubble.data.response.Loading
import com.serjshul.bubble.data.response.Success
import com.serjshul.bubble.services.LogService
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ArticleRemoteDataSource @Inject constructor(
    private val logService: LogService,
    private val firestore: FirebaseFirestore
) : ArticleDataSource {
    override suspend fun setArticle(article: Article.Draft): Response<String> {
        return try {
            try {
                val type = article.getTypeWithErrorsCheck()
                val checkTypeResponse = checkTypeExistence(type)
                if (checkTypeResponse is Failure) {
                    // TODO:
                }
            } catch (e: IllegalStateException) {
                logService.logDataException(e)
            }




            try {
                val tags = article.getTagsWithErrorsCheck()
            } catch (e: IllegalStateException) {
                logService.logDataException(e)
            }

            val document = article.toDoc()
            try {
                val content = article.getContentWithErrorsCheck()
            } catch (e: IllegalStateException) {
                logService.logDataException(e)
            }

            val result = firestore
                .collection(Collections.ARTICLES)
                .add(document)
                .await()
            logService.logDataSetting(
                source = Sources.FIRESTORE,
                type = DataTypes.ARTICLE,
                id = result.id
            )
            Success(source = Sources.FIRESTORE, data = result.id)
        } catch(e: Exception) {
            logService.logRemoteDataSourceException(e)
            Failure(source = Sources.FIRESTORE, e = e)
        }
    }

    override suspend fun checkTypeExistence(type: Type): Response<String> {
        return try {
            var response: Response<String> = Loading(source = Sources.FIRESTORE)

            firestore
                .collection(Collections.TYPES)
                .document(type.id!!)
                .get()
                .addOnSuccessListener { document ->
                    if (document.exists()) {
                        logService.logDataExistence(
                            source = Sources.FIRESTORE,
                            type = DataTypes.TYPE,
                            id = type.id,
                            isExist = true
                        )
                        response = Success(source = Sources.FIRESTORE, data = document.id)
                    } else {
                        logService.logDataExistence(
                            source = Sources.FIRESTORE,
                            type = DataTypes.TYPE,
                            id = type.id,
                            isExist = false
                        )
                        response = Failure(source = Sources.FIRESTORE, e = Exception())
                    }
                }
                .addOnFailureListener { e ->
                    logService.logRemoteDataSourceException(e)
                    response = Failure(source = Sources.FIRESTORE, e = e)
                }

            response
        } catch(e: Exception) {
            logService.logRemoteDataSourceException(e)
            Failure(source = Sources.FIRESTORE, e = e)
        }
    }
}