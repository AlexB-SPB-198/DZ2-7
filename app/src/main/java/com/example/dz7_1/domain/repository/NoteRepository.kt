package com.example.dz7_1.domain.repository

import com.example.dz7_1.domain.model.Note

interface NoteRepository {

    fun createNote(note: Note)

    fun getAllNote():List<Note>

    fun editNote(note: Note)

    fun deleteNote(note: Note)
}