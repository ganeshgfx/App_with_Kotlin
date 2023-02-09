package com.example.viewmodelwithkotlin

import android.util.Log
import androidx.lifecycle.ViewModel

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
}