package com.trubitsyna.homework.domain

import com.trubitsyna.homework.data.Note
import com.trubitsyna.homework.data.repository.NotesRepository
import com.trubitsyna.homework.data.repository.NotesRepositoryImpl
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(
    private val notesRepository: NotesRepository
) {
    fun execute(): Flow<List<Note>> {
        return notesRepository.getNotes()
    }
}

