package com.example.viewmodelwithkotlin

import androidx.lifecycle.ViewModel

class MainActivityViewModel(val initialValue:Int): ViewModel() {
    var count = initialValue
    fun increaseCount() {
        count++
    }
    fun decrement(){
        count--
    }
}