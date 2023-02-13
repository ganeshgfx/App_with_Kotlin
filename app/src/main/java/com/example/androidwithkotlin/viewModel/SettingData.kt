package com.example.androidwithkotlin.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SettingData : ViewModel(){
    var display = MutableLiveData<String>("")
}