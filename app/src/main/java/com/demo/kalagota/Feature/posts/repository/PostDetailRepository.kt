package com.demo.kalagota.Feature.posts.repository

import com.demo.kalagota.Feature.posts.model.Comment
import kotlinx.coroutines.flow.Flow

interface PostDetailRepository {
    suspend fun getPostsDetails(id:Int): Flow<List<Comment>>
}