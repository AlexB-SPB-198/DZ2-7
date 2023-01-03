package com.example.dz7_1.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.dz7_1.data.model.NoteEntity

@Dao
interface NoteDao {

    @Insert
   suspend fun createNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM notes")
  suspend  fun getAllNotes(): List<NoteEntity>

    @Update
   suspend fun editNotes(noteEntity: NoteEntity)

    @Delete
   suspend fun deleteNotes(noteEntity: NoteEntity)
}