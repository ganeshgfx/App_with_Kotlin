package com.example.androidwithkotlin.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("netImage")
fun ImageView.netImage(url:String){
    Glide.with(this.context).load(url).into(this)
}