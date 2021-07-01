package com.example.harajtask.ui.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.harajtask.R
import com.example.harajtask.databinding.PostListItemBinding
import com.example.harajtask.models.Post

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {
    private var posts: MutableList<Post> = mutableListOf()

    fun setPosts(posts: MutableList<Post>) {
        this.posts = posts
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding: PostListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.post_list_item,
            parent,
            false
        )
        return PostViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    class PostViewHolder(var binding: PostListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            binding.post = post
        }
    }
}