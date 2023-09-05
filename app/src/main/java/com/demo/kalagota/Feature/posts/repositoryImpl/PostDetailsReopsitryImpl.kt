package com.demo.kalagota.Feature.posts.repositoryImpl

import com.demo.kalagota.Feature.posts.data.DataSource.PostDataSource
import com.demo.kalagota.Feature.posts.data.DataSource.PostDetailsDataSource
import com.demo.kalagota.Feature.posts.model.Comment
import com.demo.kalagota.Feature.posts.repository.PostDetailRepository
import com.demo.kalagota.Feature.posts.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class PostDetailsReopsitryImpl(private val dataSource: PostDetailsDataSource) : PostDetailRepository {
    override suspend fun getPostsDetails(id:Int): Flow<List<Comment>> {
       return dataSource.getPostsDetails(id)
    }
}