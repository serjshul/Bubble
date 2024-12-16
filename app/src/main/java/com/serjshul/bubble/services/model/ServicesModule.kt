package com.serjshul.bubble.services.model

import com.google.firebase.firestore.FirebaseFirestore
import com.serjshul.bubble.data.article.ArticleLocalDataSource
import com.serjshul.bubble.data.article.ArticleRemoteDataSource
import com.serjshul.bubble.data.article.ArticleRepository
import com.serjshul.bubble.services.LogService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServicesModule {
    @Provides
    @Singleton
    fun provideLogService(): LogService {
        return LogService()
    }

    @Provides
    @Singleton
    fun provideArticleLocalDataSource(): ArticleLocalDataSource {
        return ArticleLocalDataSource()
    }

    @Provides
    @Singleton
    fun provideArticleRemoteDataSource(
        firestore: FirebaseFirestore
    ): ArticleRemoteDataSource {
        return ArticleRemoteDataSource(firestore)
    }

    @Provides
    @Singleton
    fun provideArticleRepository(
        localDataSource: ArticleLocalDataSource,
        remoteDataSource: ArticleRemoteDataSource
    ): ArticleRepository {
        return ArticleRepository(localDataSource, remoteDataSource)
    }
}