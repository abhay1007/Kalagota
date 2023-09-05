package com.demo.kalagota.Feature.posts.data.DataSourceImpl

import com.demo.kalagota.Feature.posts.data.DataSource.PostDataSource
import com.demo.kalagota.Feature.posts.data.DataSource.PostDetailsDataSource
import com.demo.kalagota.Feature.posts.model.Comment
import com.demo.kalagota.data.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostDetailsDataSourceImpl @Inject constructor(private val apiService: ApiService) :
    PostDetailsDataSource {

    override fun getPostsDetails(id: Int): Flow<List<Comment>> {
        return flow {
            try {
                // Fetch comments from the API using apiService
                val comments = apiService.getComments(id)

                // Emit the list of comments
                emit(comments)
            } catch (e: Exception) {
                // Handle network errors or exceptions
                // You can emit an empty list or handle errors as needed
                emit(emptyList())
            }
        }.flowOn(Dispatchers.IO) // Specify the dispatcher for the Flow
    }
}
