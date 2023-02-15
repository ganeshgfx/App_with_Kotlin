package com.example.androidwithkotlin.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val name: String,
    val phone:String,
    val cratedDate : Date
)
