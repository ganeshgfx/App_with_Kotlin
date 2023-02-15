package com.example.androidwithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.example.androidwithkotlin.databinding.ActivityMainRoomBinding
import com.example.androidwithkotlin.room.Contact
import com.example.androidwithkotlin.room.ContactDatabase
import com.google.android.material.elevation.SurfaceColors
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivityRoom : AppCompatActivity() {

    lateinit var database: ContactDatabase

    lateinit var binding: ActivityMainRoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val color = SurfaceColors.SURFACE_2.getColor(this)
        window.statusBarColor = color
        window.navigationBarColor = color

        database = ContactDatabase.getDatabase(this)

        database.contactDao().selectContact().observe(this){
            binding.view.text = it.toString()
        }

        binding.add.setOnClickListener {
            GlobalScope.launch {
                database.contactDao().insertConatct(Contact(0, "john", "3124124", Date()))
            }
        }

    }
}