package com.trubitsyna.homework.domain

import com.trubitsyna.homework.data.Note
import com.trubitsyna.homework.data.repository.NotesRepository
import com.trubitsyna.homework.data.repository.NotesRepositoryImpl

class GetNotesUseCase(

    private val notesRepository: NotesRepository = NotesRepositoryImpl()
) {
    fun execute(): List<Note> {
        return notesRepository.getNotes()
    }
}

