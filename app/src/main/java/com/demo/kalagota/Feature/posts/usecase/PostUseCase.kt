package com.demo.kalagota.Feature.posts.usecase



import com.demo.kalagota.Feature.posts.model.Post
import com.demo.kalagota.Feature.posts.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostUseCase @Inject constructor(private val repository: PostRepository) {

    suspend operator fun invoke(): Flow<List<Post>> {
        return repository.getPosts()
    }
    suspend operator fun invoke(i:Int): Flow<List<Post>> {
        return repository.getFavPosts()
    }
    suspend operator fun invoke(post: Post):Flow<Long> {
        return repository.insertFavPosts(post = post)
    }
}
