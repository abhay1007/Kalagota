package com.demo.kalagota.Feature.Comments

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.codersarts.kalagota.R
import com.codersarts.kalagota.databinding.ActivityCommentBinding
import com.demo.kalagota.Feature.posts.model.Comment
import com.demo.kalagota.Feature.posts.model.CommentAdapter
import com.demo.kalagota.Feature.posts.ui.CommentViewModel
import com.demo.kalagota.Feature.posts.ui.PostDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class CommentActivity : AppCompatActivity() {
    private val viewModel:CommentViewModel by viewModels()
    private lateinit var binding: ActivityCommentBinding
    private lateinit var adapter: CommentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentBinding.inflate(layoutInflater)
        setContentView( binding.root)
        observeComment()
    }
    private fun observeComment() {
        lifecycleScope.launch {
            viewModel.comment.collect { posts: List<Comment> ->
                adapter = CommentAdapter()
                adapter.setComments(posts)
                binding.commentRecyclerView.adapter = adapter
            }

        }
        lifecycleScope.launch {
            viewModel.insert.collect {
                if(it>=0)
                Toast.makeText(this@CommentActivity,"post added to favourites",Toast.LENGTH_LONG).show()
                else
                    Toast.makeText(this@CommentActivity,"Something went wrong",Toast.LENGTH_LONG).show()

            }

        }


        lifecycleScope.launch {
            viewModel.showSnackbarEvent.collect { showSnackbar ->
                if (showSnackbar) {

                }
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_comment, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_favorite -> {
                viewModel.addPostLocal()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

}