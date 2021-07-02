package com.example.harajtask.ui.postDetails

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.harajtask.databinding.ActivityPostDetailsBinding
import com.example.harajtask.models.Post
import com.example.harajtask.utils.POST_BUNDLE_KEY

class PostDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityPostDetailsBinding
    lateinit var viewModel: PostDetailsActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        readBundle()
        bindPost()
        attachListener()
    }

    private fun readBundle() {
        val post = intent.getParcelableExtra<Post>(POST_BUNDLE_KEY)!!

        initViewModel(post)
    }

    private fun initViewModel(post: Post) {
        val factory = PostDetailsActivityViewModel.MyViewModelFactory(
            post
        )
        viewModel = ViewModelProvider(this, factory).get(PostDetailsActivityViewModel::class.java)
    }

    private fun bindPost() {
        binding.post = viewModel.post
    }

    private fun attachListener() {
        binding.ivShare.setOnClickListener {
            openNativeShare()
        }
    }

    private fun openNativeShare() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, viewModel.post.title)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, "Share post title")
        startActivity(shareIntent)
    }
}