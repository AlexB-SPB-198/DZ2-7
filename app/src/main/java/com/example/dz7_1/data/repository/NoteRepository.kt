package com.example.dz7_1.data.repository

import com.example.dz7_1.data.local.NoteDao
import com.example.dz7_1.domain.model.Note
import com.example.dz7_1.domain.repository.NoteRepository
import com.example.dz7_1.data.toNote
import com.example.dz7_1.data.toNoteEntity
import com.example.dz7_1.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
): NoteRepository {

    override fun createNote(note: Note) =  flow{
            emit(Resource.Loading())
            try {
                val data = noteDao.createNote(note.toNoteEntity())
                emit(Resource.Success(data))
            } catch (ioException : IOException){
                emit(Resource.Error(ioException.localizedMessage?:"Unknown exception"))
            }
        }.flowOn(Dispatchers.IO)


    override fun getAllNote()=  flow{
        emit(Resource.Loading())
        try {
            val data = noteDao.getAllNotes().map { it.toNote()}
            emit(Resource.Success(data))
        } catch (ioException : IOException){
            emit(Resource.Error(ioException.localizedMessage?:"Unknown exception"))
        }
    }.flowOn(Dispatchers.IO)

    override fun editNote(note: Note)=  flow{
        emit(Resource.Loading())
        try {
            val data = noteDao.editNotes(note.toNoteEntity())
            emit(Resource.Success(data))
        } catch (ioException : IOException){
            emit(Resource.Error(ioException.localizedMessage?:"Unknown exception"))
        }
    }.flowOn(Dispatchers.IO)

    override fun deleteNote(note: Note)=  flow{
        emit(Resource.Loading())
        try {
            val data = noteDao.deleteNotes(note.toNoteEntity())
            emit(Resource.Success(data))
        } catch (ioException : IOException){
            emit(Resource.Error(ioException.localizedMessage?:"Unknown exception"))
        }
    }.flowOn(Dispatchers.IO)
}