package com.demo.kalagota.Feature.posts.repositoryImpl

import com.demo.kalagota.Feature.posts.data.DataSource.PostDataSource
import com.demo.kalagota.Feature.posts.model.Post
import com.demo.kalagota.Feature.posts.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class PostRepositoryImpl(private val dataSource: PostDataSource) : PostRepository {

    override suspend fun getPosts(): Flow<List<Post>> {
        return dataSource.getPosts()
    }

    override suspend fun getFavPosts(): Flow< List<Post>> {
        return dataSource.getFavPosts()
    }

    override suspend fun insertFavPosts(post: Post): Flow<Long> {
      return dataSource.insertFav(post = post)
    }


}
