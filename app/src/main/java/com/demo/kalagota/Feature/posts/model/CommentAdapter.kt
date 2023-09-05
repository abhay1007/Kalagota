package com.demo.kalagota.Feature.posts.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codersarts.kalagota.databinding.ItemCommentBinding


class CommentAdapter() : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    private val comments = mutableListOf<Comment>()

    fun setComments(newComments: List<Comment>) {
        comments.clear()
        comments.addAll(newComments)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val binding =
            ItemCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = comments[position]
        holder.bind(comment)
    }

    override fun getItemCount(): Int = comments.size

    inner class CommentViewHolder(private val binding: ItemCommentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(comment: Comment) {
            binding.commentNameTextView.text = comment.name
            binding.commentEmailTextView.text = comment.email
            binding.commentBodyTextView.text = comment.body


        }
    }
}
