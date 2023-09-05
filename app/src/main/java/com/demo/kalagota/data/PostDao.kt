package com.demo.kalagota.data


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.demo.kalagota.Feature.posts.model.Post

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(posts: Post): Long

    @Query("SELECT * FROM POSTS")
    suspend fun getAllPosts(): List<Post>


}
