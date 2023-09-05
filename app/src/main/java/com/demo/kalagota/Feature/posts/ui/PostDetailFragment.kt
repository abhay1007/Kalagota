package com.demo.kalagota.Feature.posts.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.codersarts.kalagota.R
import com.codersarts.kalagota.databinding.FragmentPostDetailBinding
import com.demo.kalagota.Feature.posts.model.Comment
import com.demo.kalagota.Feature.posts.model.CommentAdapter
import com.demo.kalagota.Feature.posts.model.Post
import com.demo.kalagota.Feature.posts.model.PostListAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class PostDetailFragment : Fragment() {
//    private val viewModel by viewModels<PostDetailViewModel>()
    private lateinit var binding: FragmentPostDetailBinding
    private lateinit var adapter: CommentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}