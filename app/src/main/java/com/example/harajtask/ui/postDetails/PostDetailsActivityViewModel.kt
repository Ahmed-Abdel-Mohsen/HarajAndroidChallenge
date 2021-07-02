package com.example.harajtask.ui.postDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.harajtask.models.Post

class PostDetailsActivityViewModel(val post: Post) : ViewModel() {
    class MyViewModelFactory(val post: Post) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return PostDetailsActivityViewModel(post) as T
        }
    }
}