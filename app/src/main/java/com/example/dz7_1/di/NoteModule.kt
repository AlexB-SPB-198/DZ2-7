package com.example.dz7_1.di

import android.content.Context
import androidx.room.Room
import com.example.dz7_1.data.local.NoteDao
import com.example.dz7_1.data.local.NoteDataBase
import com.example.dz7_1.data.repository.NoteRepositoryImpl
import com.example.dz7_1.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    @Singleton
    @Provides
    fun provideNoteDataBase(
        @ApplicationContext context: Context
    ):NoteDataBase = Room.databaseBuilder(
        context,
        NoteDataBase::class.java,
        "note_db"
    ) .allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun provideNoteData(noteDataBase: NoteDataBase) = noteDataBase.noteDao()

    @Singleton
    @Provides
    fun providesNoteRepository(
        noteDao: NoteDao):
            NoteRepository = NoteRepositoryImpl(noteDao)
}