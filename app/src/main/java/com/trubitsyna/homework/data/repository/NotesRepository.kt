package com.trubitsyna.homework.data.repository

import android.net.Uri
import com.trubitsyna.homework.data.Note
import kotlinx.coroutines.flow.Flow

interface NotesRepository {
    fun getNotes(): Flow<List<Note>>
    suspend fun addNotes(note: Note)
    suspend fun deleteNotes(note: Note)
}