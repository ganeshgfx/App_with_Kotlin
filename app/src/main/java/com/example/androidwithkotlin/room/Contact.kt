package com.example.androidwithkotlin.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val name: String,
    val phone:String
)
