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
    fun provideArticleLocalDataSource(
        logService: LogService,
    ): ArticleLocalDataSource {
        return ArticleLocalDataSource(logService)
    }

    @Provides
    @Singleton
    fun provideArticleRemoteDataSource(
        logService: LogService,
        firestore: FirebaseFirestore
    ): ArticleRemoteDataSource {
        return ArticleRemoteDataSource(logService, firestore)
    }

    @Provides
    @Singleton
    fun provideArticleRepository(
        logService: LogService,
        localDataSource: ArticleLocalDataSource,
        remoteDataSource: ArticleRemoteDataSource
    ): ArticleRepository {
        return ArticleRepository(logService, localDataSource, remoteDataSource)
    }
}