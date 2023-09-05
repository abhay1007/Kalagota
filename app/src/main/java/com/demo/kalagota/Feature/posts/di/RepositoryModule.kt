package com.demo.kalagota.Feature.posts.di

import com.demo.kalagota.Feature.posts.data.DataSource.PostDataSource
import com.demo.kalagota.Feature.posts.data.DataSource.PostDetailsDataSource
import com.demo.kalagota.Feature.posts.repository.PostDetailRepository
import com.demo.kalagota.Feature.posts.repository.PostRepository
import com.demo.kalagota.Feature.posts.repositoryImpl.PostDetailsReopsitryImpl
import com.demo.kalagota.Feature.posts.repositoryImpl.PostRepositoryImpl


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providePostRepository(dataSource: PostDataSource): PostRepository {
        return PostRepositoryImpl(dataSource)
    }
    @Singleton
    @Provides
    fun providePostdetailsRepository(dataSource: PostDetailsDataSource): PostDetailRepository {
        return PostDetailsReopsitryImpl(dataSource)
    }
}
