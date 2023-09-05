package com.demo.kalagota.Feature.posts.data.DataSourceImpl

import com.demo.kalagota.Feature.posts.data.DataSource.PostDataSource
import com.demo.kalagota.Feature.posts.model.Post
import com.demo.kalagota.data.ApiService
import com.demo.kalagota.data.PostDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject



class PostDataSourceImpl @Inject constructor(private val apiService: ApiService, private val siteDao: PostDao) :
    PostDataSource {


    override fun getPosts(): Flow<List<Post>> = flow {
        try {
            val posts = apiService.getPosts()

            emit(posts)
        } catch (e: Exception) {

            emit(emptyList())
        }
    }

    override  fun getFavPosts(): Flow<List<Post>> = flow{
        try {

            val posts = siteDao.getAllPosts()


            emit(posts)
        } catch (e: Exception) {

            emit(emptyList())
        }
    }

    override  suspend fun insertFav(post: Post)=flow {
            val posts = siteDao.insertPosts(posts = post)
        emit(posts)

    }


}
