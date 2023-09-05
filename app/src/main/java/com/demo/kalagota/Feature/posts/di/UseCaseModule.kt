package com.demo.kalagota.Feature.posts.di


import com.demo.kalagota.Feature.posts.repository.PostRepository
import com.demo.kalagota.Feature.posts.usecase.PostUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetPostsUseCase(repository: PostRepository): PostUseCase {
        return PostUseCase(repository)
    }
}
