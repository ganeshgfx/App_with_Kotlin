package com.example.androidwithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.androidwithkotlin.ViewModel.MainActivityViewModelFactory
import com.example.viewmodelwithkotlin.MainActivityViewModel
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    lateinit var button: ExtendedFloatingActionButton
    lateinit var text: TextView

    val TAG = "TAG"

    //View Model Object
    lateinit var mainViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this, MainActivityViewModelFactory(9)).get(MainActivityViewModel::class.java)

        button = findViewById(R.id.incrementBTN)
        button.setOnClickListener {
            mainViewModel.increaseCount()

            //Coroutines
            CoroutineScope(Dispatchers.IO).launch{
                Log.d(TAG, "CoroutineScope - ${Thread.currentThread().name}")
            }
            GlobalScope.launch(Dispatchers.Main) {
                Log.d(TAG, "GlobalScope - ${Thread.currentThread().name}")
            }
            MainScope().launch(Dispatchers.Default) {
                Log.d(TAG, "MainScope - ${Thread.currentThread().name}")
            }
            setCount()

        }
        button.setOnLongClickListener{
            mainViewModel.decrement()
            setCount()
            true
        }
        text = findViewById(R.id.text)
        setCount()
    }
    fun setCount(){
        text.text = mainViewModel.count.toString()
    }
}