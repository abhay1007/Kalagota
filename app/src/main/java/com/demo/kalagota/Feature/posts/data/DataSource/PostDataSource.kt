package com.demo.kalagota.Feature.posts.data.DataSource

import com.demo.kalagota.Feature.posts.model.Post
import kotlinx.coroutines.flow.Flow

interface PostDataSource {
    fun getPosts(): Flow<List<Post>>
    fun getFavPosts():Flow<List<Post>>
    suspend fun insertFav(post: Post):Flow<Long>
}
