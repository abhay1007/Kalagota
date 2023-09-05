package com.demo.kalagota.Feature.posts.model


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.codersarts.kalagota.R
import com.codersarts.kalagota.databinding.ItemPostBinding
import com.demo.kalagota.Feature.Comments.CommentActivity
import com.demo.kalagota.Feature.posts.ui.PostDetailFragment


class PostListAdapter(private val mList: List<Post>,private val activity: Activity) : RecyclerView.Adapter<PostListAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding =
            ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int {
      return  mList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = mList.get(position)
        holder.bind(post)
    }

    inner class PostViewHolder(private val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        private lateinit var post: Post

        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(post: Post) {
            this.post = post
            binding.titleTextView.text = post.title
            binding.bodyTextView.text = post.body
            binding.itemPostLayout.setOnClickListener {
                val post = Post(id = 1, userId = 1, title = post.title, body = post.body)

                val bundle = Bundle()
                bundle.putParcelable("post_details", post)

                val intent = Intent(activity, CommentActivity::class.java)

                // Attach the Bundle to the Intent
                intent.putExtras(bundle)

                // Start CommentActivity
              activity.startActivity(intent)

            }

        }

        override fun onClick(p0: View?) {
            TODO("Not yet implemented")
        }


    }


}
