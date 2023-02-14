package com.example.androidwithkotlin.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDAO {
    @Insert
    suspend fun insertConatct(contact: Contact)
    @Update
    suspend fun updateConatct(contact: Contact)
    @Delete
    suspend fun deletConatct(contact: Contact)
    @Query("SELECT * FROM contact")
    fun selectContact():LiveData<List<Contact>>

}