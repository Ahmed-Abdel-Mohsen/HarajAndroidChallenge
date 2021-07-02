package com.example.harajtask.ui.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.harajtask.R
import com.example.harajtask.databinding.PostListItemBinding
import com.example.harajtask.models.Post

class PostsAdapter(val listener: PostClickListener) :
    RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {
    private var posts: Array<Post> = arrayOf()

    fun setPosts(posts: Array<Post>) {
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

    inner class PostViewHolder(var binding: PostListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            binding.post = post

            binding.root.setOnClickListener {
                listener.onClickPost(post)
            }
        }
    }

    interface PostClickListener {
        fun onClickPost(post: Post)
    }
}