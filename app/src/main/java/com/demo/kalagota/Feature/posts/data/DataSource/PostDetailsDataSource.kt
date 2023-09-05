package com.demo.kalagota.Feature.posts.data.DataSource

import com.demo.kalagota.Feature.posts.model.Comment
import kotlinx.coroutines.flow.Flow

interface PostDetailsDataSource {
    fun getPostsDetails(id:Int): Flow<List<Comment>>
}