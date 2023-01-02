package com.example.dz7_1.data

import com.example.dz7_1.data.model.NoteEntity
import com.example.dz7_1.domain.model.Note

fun Note.toNoteEntity() = NoteEntity(
    id, title, description, createAt
)

fun NoteEntity.toNote() = Note(
    id, title, description, createAt
)