package com.example.androidwithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.androidwithkotlin.room.Contact
import com.example.androidwithkotlin.room.ContactDatabase
import com.google.android.material.elevation.SurfaceColors
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivityRoom : AppCompatActivity() {

    lateinit var database : ContactDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_room)

        val color = SurfaceColors.SURFACE_2.getColor(this)
        window.statusBarColor = color
        window.navigationBarColor = color

       database = Room.databaseBuilder(applicationContext,ContactDatabase::class.java,"contactDB").build()

       GlobalScope.launch {
           database.contactDao().insertConatct(Contact(0,"john","3124124"))
       }

    }
}