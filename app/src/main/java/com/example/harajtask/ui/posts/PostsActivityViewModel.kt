package com.example.harajtask.ui.posts

import android.content.res.AssetManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.harajtask.models.Post
import com.google.gson.Gson

class PostsActivityViewModel : ViewModel() {
    val postsLiveData: MutableLiveData<Array<Post>> = MutableLiveData()

    fun loadPosts(assets: AssetManager) {
        val str = assets.open("data.json").bufferedReader().use { it.readText() }

        postsLiveData.value = Gson().fromJson(str, Array<Post>::class.java)
    }
}