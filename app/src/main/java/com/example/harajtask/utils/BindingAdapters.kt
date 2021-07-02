package com.example.harajtask.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.BindingAdapter
import com.example.harajtask.R
import com.squareup.picasso.Picasso

@BindingAdapter("app:src")
fun loadImage(imageView: ImageView, url: String?) {
    Picasso.get()
        .load(url)
        .placeholder(
            AppCompatResources.getDrawable(
                imageView.context,
                R.drawable.ic_launcher_background
            )!!
        )
        .error(
            AppCompatResources.getDrawable(
                imageView.context,
                R.drawable.ic_launcher_background
            )!!
        )
        .into(imageView)
}

@BindingAdapter("app:timeText")
fun timeText(textView: TextView, timeStamp: Long) {
    textView.text = DateUtils.getTimeString(timeStamp)
}