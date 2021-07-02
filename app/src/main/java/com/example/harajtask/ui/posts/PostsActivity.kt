package com.example.harajtask.ui.posts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.harajtask.databinding.ActivityPostsBinding
import com.example.harajtask.models.Post

class PostsActivity : AppCompatActivity() {
    lateinit var binding: ActivityPostsBinding
    lateinit var viewModel: PostsActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
        setupObservers()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(PostsActivityViewModel::class.java)

        viewModel.loadPosts(assets)
    }

    private fun setupObservers() {
        viewModel.postsLiveData.observe(this, {
            displayPosts(it)
        })
    }

    private fun displayPosts(posts: Array<Post>) {
        val adapter = PostsAdapter()

        adapter.setPosts(posts)

        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )

        binding.rvPosts.layoutManager = linearLayoutManager

        binding.rvPosts.adapter = adapter
    }
}