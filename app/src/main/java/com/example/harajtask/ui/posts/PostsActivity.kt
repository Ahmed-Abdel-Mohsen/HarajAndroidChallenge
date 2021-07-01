package com.example.harajtask.ui.posts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.harajtask.R
import com.example.harajtask.databinding.ActivityPostsBinding
import com.example.harajtask.models.Post
import com.google.gson.Gson

class PostsActivity : AppCompatActivity() {
    lateinit var binding: ActivityPostsBinding
    var posts: MutableList<Post> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        readJson()
    }

    private fun readJson() {
        val str = assets.open("data.json").bufferedReader().use { it.readText() }

        posts = Gson().fromJson(str, Array<Post>::class.java).toMutableList()

        posts.forEach{
            Log.d("jj1", "userName: " + it.username)
            Log.d("jj1", "timestamp: " + it.date)
        }

        val adapter = PostsAdapter()

        adapter.setPosts(posts)

        val linearLayoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)

        binding.rvPosts.layoutManager = linearLayoutManager

        binding.rvPosts.adapter = adapter
    }
}