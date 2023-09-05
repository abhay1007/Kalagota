package com.demo.kalagota.Feature.posts.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.kalagota.Feature.posts.model.Post
import com.demo.kalagota.Feature.posts.usecase.PostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostListViewModel @Inject constructor(
    private val postUseCase: PostUseCase,
) : ViewModel() {

    private val _posts = Channel<List<Post>>(Channel.BUFFERED)
    val posts= _posts.receiveAsFlow()

    private val _showSnackbarEvent = MutableStateFlow(false)
    val showSnackbarEvent: StateFlow<Boolean> = _showSnackbarEvent

    init {
        loadPosts()
    }

    private fun loadPosts() {
        viewModelScope.launch {
            try {
                val result = postUseCase.invoke()

                result.collect{
                    post->
                    if (post.isNullOrEmpty()){
                        _showSnackbarEvent.value = true
                    }
                    _posts.send(post)
                }
            } catch (e: Exception) {
                _showSnackbarEvent.value = true
            }
        }
    }
}
