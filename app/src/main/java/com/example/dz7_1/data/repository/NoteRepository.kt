package com.example.dz7_1.data.repository

import com.example.dz7_1.data.local.NoteDao
import com.example.dz7_1.domain.model.Note
import com.example.dz7_1.domain.repository.NoteRepository
import com.example.dz7_1.data.toNote
import com.example.dz7_1.data.toNoteEntity

class NoteRepositoryImpl(private val noteDao: NoteDao): NoteRepository {
    override fun createNote(note: Note) {
        noteDao.createNote(note.toNoteEntity())


    }

    override fun getAllNote(): List<Note> {
      return  noteDao.getAllNotes().map { it.toNote() }
    }

    override fun editNote(note: Note) {
        noteDao.editNotes(note.toNoteEntity())
    }

    override fun deleteNote(note: Note) {
        noteDao.deliteNotes(note.toNoteEntity())
    }
}