package com.serjshul.bubble.services.model

import com.google.firebase.firestore.FirebaseFirestore
import com.serjshul.bubble.data.local.ArticleLocalDataSource
import com.serjshul.bubble.services.LogService
import com.serjshul.bubble.data.remote.ArticleRemoteDataSource
import com.serjshul.bubble.data.repository.ArticleRepository
import com.serjshul.bubble.services.impl.LogServiceImpl
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
        return LogServiceImpl()
    }

    @Provides
    @Singleton
    fun provideArticleLocalDataSource(): ArticleLocalDataSource {
        return ArticleLocalDataSource()
    }

    @Provides
    @Singleton
    fun provideArticleRemoteDataSource(firestore: FirebaseFirestore): ArticleRemoteDataSource {
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