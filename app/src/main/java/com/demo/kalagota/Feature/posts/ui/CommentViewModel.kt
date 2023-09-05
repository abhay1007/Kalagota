package com.demo.kalagota.Feature.posts.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.kalagota.Feature.posts.model.Comment
import com.demo.kalagota.Feature.posts.model.Post
import com.demo.kalagota.Feature.posts.usecase.GetCommentUseCase
import com.demo.kalagota.Feature.posts.usecase.PostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommentViewModel @Inject constructor(
    private val commentUseCase: GetCommentUseCase,
    private val postUseCase: PostUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _comment = Channel<List<Comment>>(Channel.BUFFERED)
    val comment: Flow<List<Comment>> = _comment.receiveAsFlow()
    private val _insert = Channel<Long>(Channel.BUFFERED)
    val insert: Flow<Long> =_insert.receiveAsFlow()
    lateinit var post:Post
    private val _showSnackbarEvent = MutableStateFlow(false)
    val showSnackbarEvent: StateFlow<Boolean> = _showSnackbarEvent

    init {
       post = savedStateHandle.get<Post>("post_details")!!
        if (post != null) {
            loadComment(post.id)
        }
    }

    private fun loadComment(id: Int) {
        viewModelScope.launch {
            try {
                val result = commentUseCase.invoke(id = id)

                result.collect { post ->
                    if (post.isNullOrEmpty()) {
                        _showSnackbarEvent.value = true
                    }
                    _comment.send(post)
                }
            } catch (e: Exception) {
                _showSnackbarEvent.value = true
            }
        }
    }
     fun addPostLocal(){
        viewModelScope.launch {
            val result=postUseCase.invoke(post =post )
            result.collect{
                if(it>=0){
                    _insert.send(it)
                }
                else
                    _showSnackbarEvent.value = true
            }
        }
    }
}
