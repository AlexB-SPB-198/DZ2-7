package com.example.dz7_1.domain.usecase

import com.example.dz7_1.domain.repository.NoteRepository
import javax.inject.Inject

class GetAllNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository) {
    fun getAllNote() = noteRepository.getAllNote()

}