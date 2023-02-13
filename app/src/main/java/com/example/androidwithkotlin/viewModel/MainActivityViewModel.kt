package com.example.viewmodelwithkotlin

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivityViewModel(val initialValue:Int): ViewModel() {
    var count = initialValue
    fun increaseCount() {
        count++
    }
    fun decrement(){
        count--
    }
    fun reset(){
        count = 0
    }
    //viewModelScope
    init {
        viewModelScope.launch{
            while (true){
                delay(500)
                Log.d("TAG", " In ViewModel ")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("TAG", "onCleared: ViewModel")
    }
}