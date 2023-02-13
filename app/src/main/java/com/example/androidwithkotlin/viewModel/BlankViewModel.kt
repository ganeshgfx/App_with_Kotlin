package com.example.androidwithkotlin.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BlankViewModel : ViewModel() {
   private var _liveData =  MutableLiveData<String>("Welcome Page")
    val liveData : LiveData<String>
    get() = _liveData

    fun update(data:String){
        _liveData.value = data
    }

    fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
       _liveData.value = s.toString()
    }
}