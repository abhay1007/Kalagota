package com.demo.kalagota.Feature.posts.di

import com.demo.kalagota.Feature.posts.data.DataSource.PostDataSource
import com.demo.kalagota.Feature.posts.data.DataSource.PostDetailsDataSource
import com.demo.kalagota.Feature.posts.data.DataSourceImpl.PostDataSourceImpl
import com.demo.kalagota.Feature.posts.data.DataSourceImpl.PostDetailsDataSourceImpl
import com.demo.kalagota.Feature.posts.model.AppDatabase
import com.demo.kalagota.data.ApiService
import com.demo.kalagota.data.PostDao
import dagger.hilt.components.SingletonComponent
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun providePostDataSource(apiService: ApiService,siteDao: PostDao): PostDataSource {
        return PostDataSourceImpl(apiService,siteDao)
    }
    @Singleton
    @Provides
    fun providePostDetailsDataSource(apiService: ApiService): PostDetailsDataSource {
        return PostDetailsDataSourceImpl(apiService)
    }
    @Provides
    @Singleton
    fun providePostDao(database: AppDatabase): PostDao {
        return database.postDao()
    }
}
