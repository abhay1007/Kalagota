package com.demo.kalagota.Feature.posts.Module
import android.content.Context

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

//    @Singleton
//    @Provides
//    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
//        return Room.databaseBuilder(
//            context,
//            AppDatabase::class.java,
//            "app_database"
//        ).build()
//    }
//
//    @Provides
//    fun providePostDao(appDatabase: AppDatabase): PostDao {
//        return appDatabase.postDao()
//    }
}
