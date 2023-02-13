package com.example.androidwithkotlin.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SettingData : ViewModel(){
    var display = MutableLiveData<String>("")
    var url:String = "https://source.unsplash.com/gySMaocSdqs/600x300"
}