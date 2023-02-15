package com.example.androidwithkotlin.room

import android.content.Context
import androidx.room.*
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [Contact::class,Student::class],
    version = 4,
    autoMigrations = [
        AutoMigration(from = 1, to = 2),
        AutoMigration(from = 2, to = 3, spec = ContactDatabase.Migration2to3::class)
    ],
    exportSchema = true
)
@TypeConverters(Converter::class)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDAO

    companion object {
        @Volatile
        private var INSTANCE: ContactDatabase? = null
        fun getDatabase(context: Context): ContactDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java,
                        "contactDB"
                    )
                        .addMigrations(migration3to4)
                        .build()
                }
            }
            return INSTANCE!!
        }
        private val migration3to4 = object : Migration(3, 4) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE IF NOT EXISTS student(name TEXT NOT NULL PRIMARY KEY)")
            }
        }
    }

    @RenameColumn(tableName = "Contact", fromColumnName = "cratedDate", toColumnName = "cratedDateAt")
    class Migration2to3 : AutoMigrationSpec

}