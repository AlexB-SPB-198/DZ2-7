package com.example.dz7_1.domain.usecase

import com.example.dz7_1.domain.model.Note
import com.example.dz7_1.domain.repository.NoteRepository

class CreateNoteUseCase(
    private val noteRepository: NoteRepository){

    fun createNote(note: Note) = noteRepository.createNote(note)

}