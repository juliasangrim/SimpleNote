package com.trubitsyna.homework.domain

import android.net.Uri
import android.util.Log
import com.trubitsyna.homework.data.Note
import com.trubitsyna.homework.data.repository.NotesRepository
import com.trubitsyna.homework.data.repository.NotesRepositoryImpl
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(
    private val notesRepository: NotesRepository
) {
    suspend fun execute(note: Note) {
        notesRepository.addNotes(note)
    }

}