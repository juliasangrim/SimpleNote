package com.trubitsyna.homework.domain

import com.trubitsyna.homework.data.repository.NotesRepository
import com.trubitsyna.homework.data.repository.NotesRepositoryImpl
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(
    private val notesRepository: NotesRepository
) {
    suspend fun execute(text: String) {
        notesRepository.addNotes(text)
    }

}