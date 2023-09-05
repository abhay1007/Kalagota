package com.demo.kalagota.Feature.posts.usecase

import com.demo.kalagota.Feature.posts.model.Comment
import com.demo.kalagota.Feature.posts.model.Post
import com.demo.kalagota.Feature.posts.repository.PostDetailRepository
import com.demo.kalagota.Feature.posts.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCommentUseCase@Inject constructor(private val repository: PostDetailRepository) {

    suspend operator fun invoke(id:Int): Flow<List<Comment>> {
        return repository.getPostsDetails(id = id)
    }
}