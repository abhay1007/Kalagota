package com.demo.kalagota.data

import com.demo.kalagota.Feature.posts.model.Comment
import com.demo.kalagota.Feature.posts.model.Post

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/posts")
    suspend fun getPosts(): List<Post>

    @GET("/posts/{post_id}/comments")
    suspend fun getComments(@Path("post_id") postId: Int): List<Comment>

}
