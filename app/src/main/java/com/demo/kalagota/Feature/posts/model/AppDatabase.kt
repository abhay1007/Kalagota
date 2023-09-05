package com.demo.kalagota.Feature.posts.model

import com.demo.kalagota.Feature.posts.model.Post;

import androidx.room.Database
import androidx.room.RoomDatabase
import com.demo.kalagota.data.PostDao

@Database(entities = [Post::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}
