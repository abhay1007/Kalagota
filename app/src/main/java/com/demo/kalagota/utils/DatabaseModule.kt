package com.demo.kalagota.utils

import android.content.Context
import androidx.room.Room
import com.demo.kalagota.Feature.posts.model.AppDatabase
import com.demo.kalagota.data.PostDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideAppdaqtabase(@ApplicationContext applicationContext: Context): AppDatabase {
        return Room.databaseBuilder(applicationContext, AppDatabase::class.java, "Post").build()
    }
}


