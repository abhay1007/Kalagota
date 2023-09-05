package com.demo.kalagota.Feature.posts.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.kalagota.Feature.posts.model.Comment
import com.demo.kalagota.Feature.posts.model.Post
import com.demo.kalagota.Feature.posts.usecase.GetCommentUseCase
import com.demo.kalagota.Feature.posts.usecase.PostUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class PostDetailViewModel@Inject constructor(
    private val commentUseCase: GetCommentUseCase,
    private val savedStateHandle: SavedStateHandle

) : ViewModel() {

    private val _comment = Channel<List<Comment>>(Channel.BUFFERED)
    val comment= _comment.receiveAsFlow()

    private val _showSnackbarEvent = MutableStateFlow(false)
    val showSnackbarEvent: StateFlow<Boolean> = _showSnackbarEvent

    init {
        val post = savedStateHandle.get<Post>("post_details")
        if (post != null) {
            // Use the 'post' object as needed in your ViewModel
            loadComment(post.id)
        }

    }

    private fun loadComment(id: Int) {
        viewModelScope.launch {
            try {
                val result = commentUseCase.invoke(id = id)

                result.collect{
                        post->
                    if (post.isNullOrEmpty()){
                        _showSnackbarEvent.value = true
                    }
                    _comment.send(post)
                }
            } catch (e: Exception) {
                _showSnackbarEvent.value = true
            }
        }
    }
}
