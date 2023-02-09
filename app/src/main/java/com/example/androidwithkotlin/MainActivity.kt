package com.example.androidwithkotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.androidwithkotlin.ViewModel.MainActivityViewModelFactory
import com.example.viewmodelwithkotlin.MainActivityViewModel
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    lateinit var button: ExtendedFloatingActionButton
    lateinit var text: TextView
    lateinit var textSpeed: TextView

    val TAG = "TAG"

    //View Model Object
    lateinit var mainViewModel: MainActivityViewModel

    @OptIn(DelicateCoroutinesApi::class)
    @SuppressLint("AppCompatMethod")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        mainViewModel = ViewModelProvider(
            this,
            MainActivityViewModelFactory(0)
        ).get(MainActivityViewModel::class.java)

        text = findViewById(R.id.text)
        textSpeed = findViewById(R.id.size)

        button = findViewById(R.id.incrementBTN)
        button.setOnClickListener {


            MainScope().launch(Dispatchers.Default) {
                // Log.d(TAG, "CoroutineScope - ${Thread.currentThread().name}")
            }

            //Coroutines
            CoroutineScope(Dispatchers.IO).launch {
                // Log.d(TAG, "CoroutineScope - ${Thread.currentThread().name}")
            }
            GlobalScope.launch(Dispatchers.Main) {
                // Log.d(TAG, "GlobalScope - ${Thread.currentThread().name}")
                async { loading() }

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

            //jobs
            CoroutineScope(Dispatchers.IO).launch {
                printFileSize2()
            }
            //async wait
            CoroutineScope(Dispatchers.Main).launch{
                var size = async{ getFileSize() }
                var time = async { getTime() }
                textSpeed.setText("${size.await()}GB - ${time.await()}s")
            }

        }
        button.setOnLongClickListener {
            mainViewModel.decrement()
            setCount()
            true
        }
        setCount()

        //lifecycle Scope
        lifecycleScope.launch(){
            delay(5000)
            //finish()
        }
    }

    //coroutine j0b
    private suspend fun printFileSize() {
        var fileSize = 0
        var job = CoroutineScope(Dispatchers.IO).launch {
            fileSize = getFileSize()
        }
        job.join()
        //Toast.makeText(this, "File size is $fileSize GB", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "printFileSize: $fileSize GB")
    }
    //async
    private suspend fun printFileSize2() {
        var job = CoroutineScope(Dispatchers.IO).async {
            getFileSize()
        }
        //Toast.makeText(this, "File size is $fileSize GB", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "printFileSize: ${job.await()} GB")
    }

    fun setCount() {
        text.text = "Downloading... ${mainViewModel.count.toString()}"
    }

    //Coroutine Suspension
    suspend fun task1() {
        // Log.d(TAG, "Task1: Started")
        yield()
        //Log.d(TAG, "Task1: Stopped")
    }

    suspend fun task2() {
        //Log.d(TAG, "task2: Started")
        yield()
        //Log.d(TAG, "task2: Stopped")
    }

    //suspended
    suspend fun loading() {
        mainViewModel.reset()
        for (i in 1..100) {
            val timeMillis = (10..50).random().toLong()
            //Log.d(TAG, timeMillis.toString())
            delay(timeMillis)
            mainViewModel.increaseCount()
            setCount()
        }
    }

    suspend fun getFileSize(): Int {
        delay(5000)
        return 19
    }

    suspend fun getTime():Int{
        val timeMillis = (10..500).random().toLong()
        delay(timeMillis)
        return (1..5).random()
    }
}