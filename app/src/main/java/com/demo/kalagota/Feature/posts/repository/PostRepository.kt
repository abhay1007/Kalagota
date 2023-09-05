package com.demo.kalagota.Feature.posts.repository

import com.demo.kalagota.Feature.posts.model.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    suspend fun getPosts(): Flow<List<Post>>
    suspend fun getFavPosts(): Flow<List<Post>>
    suspend fun insertFavPosts(post: Post):Flow<Long>
}
