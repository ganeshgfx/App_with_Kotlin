package com.example.androidwithkotlin.room

import android.content.Context
import androidx.room.*

@Database(entities = [Contact::class], version = 1)
@TypeConverters(Converter::class)
abstract class ContactDatabase:RoomDatabase() {
    abstract fun contactDao():ContactDAO
    companion object{
        @Volatile
        private var INSTANCE : ContactDatabase? = null
        fun getDatabase(context: Context): ContactDatabase{
            if (INSTANCE==null){
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java,
                        "contactDB"
                    )
                        .build()
                }
            }
            return INSTANCE!!
        }

    }
}