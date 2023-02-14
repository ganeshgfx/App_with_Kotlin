package com.example.androidwithkotlin.adapters

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.androidwithkotlin.R

@BindingAdapter("netImage")
fun ImageView.netImage(url:String){

    var img:ImageView = this

    Glide.with(this.context)
        .load(url)
        .placeholder(android.R.drawable.ic_lock_idle_alarm)
        .into(this)
}