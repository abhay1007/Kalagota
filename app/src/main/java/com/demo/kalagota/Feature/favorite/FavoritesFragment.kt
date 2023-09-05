package com.demo.kalagota.Feature.favorite

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.codersarts.kalagota.R
import com.codersarts.kalagota.databinding.FragmentFavoritesBinding
import com.codersarts.kalagota.databinding.FragmentPostListBinding
import com.demo.kalagota.Feature.posts.model.Post
import com.demo.kalagota.Feature.posts.model.PostListAdapter
import com.demo.kalagota.Feature.posts.ui.PostListViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoritesFragment : Fragment() {
    private lateinit var adapter: PostListAdapter
    private val viewModel by viewModels<FavoritesViewModel>()

    private lateinit var binding: FragmentFavoritesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        observePosts()
    }

    private fun observePosts() {
        lifecycleScope.launch {
            viewModel.posts.collect { posts: List<Post> ->
                adapter = PostListAdapter(posts, requireActivity())
                binding.postRecyclerView.adapter = adapter
            }

        }


        lifecycleScope.launch {
            viewModel.showSnackbarEvent.collect { showSnackbar ->
                if (showSnackbar) {
                    Snackbar.make(requireView(), "No internet connection", Snackbar.LENGTH_LONG)
                        .show()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadPosts()
    }
}