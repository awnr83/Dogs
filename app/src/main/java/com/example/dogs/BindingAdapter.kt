package com.example.dogs

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun convertStringImage(image: ImageView, imgUrl: String?){
    imgUrl?.let {
        val imgUrl= it.toUri().buildUpon().scheme("https").build()
        Glide.with(image.context).load(imgUrl).into(image)
    }
}