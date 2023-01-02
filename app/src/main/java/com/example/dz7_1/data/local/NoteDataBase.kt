package com.example.dz7_1.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dz7_1.data.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDataBase:RoomDatabase() {

    abstract fun noteDao():NoteDao
}