package com.example.androidwithkotlin.room

import androidx.room.TypeConverter
import java.util.*

class Converter {
    @TypeConverter
    fun fromDateToLong(value: Date):Long{
        return value.time
    }
    @TypeConverter
    fun fromlongToDate(value:Long):Date{
        return Date(value)
    }
}