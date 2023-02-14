package com.example.androidwithkotlin.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelwithkotlin.MainActivityViewModel

class MainActivityViewModelFactory(val counter:LiveData<Int>):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(counter as MutableLiveData<Int>) as T
    }
}