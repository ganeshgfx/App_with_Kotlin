package com.example.viewmodelwithkotlin

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivityViewModel(val initialValue:MutableLiveData<Int>): ViewModel() {
    var count = initialValue
    fun increaseCount() {
        count.value = count.value?.plus(1)
    }
    fun decrement(){
        count.value= count.value?.minus(1)
    }
    fun reset(){
        count.value = 0
    }
    //viewModelScope
    init {
//        viewModelScope.launch{
//            while (true){
//                delay(500)
//                Log.d("TAG", " In ViewModel")
//            }
//        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("TAG", "onCleared: ViewModel")
    }
}