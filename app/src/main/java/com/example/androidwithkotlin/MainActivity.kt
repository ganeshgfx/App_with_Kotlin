package com.example.androidwithkotlin

import android.annotation.SuppressLint
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

    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("AppCompatMethod")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        mainViewModel = ViewModelProvider(this, MainActivityViewModelFactory(0)).get(MainActivityViewModel::class.java)

        button = findViewById(R.id.incrementBTN)
        button.setOnClickListener {



            MainScope().launch(Dispatchers.Default){
                // Log.d(TAG, "CoroutineScope - ${Thread.currentThread().name}")

            }

            //Coroutines
            CoroutineScope(Dispatchers.IO).launch{
               // Log.d(TAG, "CoroutineScope - ${Thread.currentThread().name}")
            }
            GlobalScope.launch(Dispatchers.Main) {
                // Log.d(TAG, "GlobalScope - ${Thread.currentThread().name}")
               loading()
            }
            MainScope().launch(Dispatchers.Default) {
               // Log.d(TAG, "MainScope - ${Thread.currentThread().name}")

            }

            CoroutineScope(Dispatchers.Main).launch {
                task1()
            }
            CoroutineScope(Dispatchers.Main).launch {
                task2()
            }

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
            text.text = "Downloading... ${mainViewModel.count.toString()}"
    }

    //Coroutine Suspension
    suspend fun task1(){
        Log.d(TAG, "Task1: Started")
        yield()
        Log.d(TAG, "Task1: Stopped")
    }
    suspend fun task2(){
        Log.d(TAG, "task2: Started")
        yield()
        Log.d(TAG, "task2: Stopped")
    }
    suspend fun loading(){
        mainViewModel.reset()
        for (i in 1..100){
            val timeMillis = (10..50).random().toLong()
            //Log.d(TAG, timeMillis.toString())
            delay(timeMillis)
            mainViewModel.increaseCount()
            setCount()
        }
    }
}