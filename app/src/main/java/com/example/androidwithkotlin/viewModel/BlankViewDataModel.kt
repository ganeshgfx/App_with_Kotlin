package com.example.androidwithkotlin.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BlankViewDataModel : ViewModel() {
    var _liveData =  MutableLiveData<String>("Welcome Page Fragment")

    fun update(data:String){
        _liveData.value = data
    }

    fun getVal() = _liveData.value

    fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
       update(s.toString())
        Log.d("TAG", "onTextChanged: ${s}")
    }
}