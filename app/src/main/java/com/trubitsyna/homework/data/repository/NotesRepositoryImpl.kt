package com.trubitsyna.homework.data.repository

import com.trubitsyna.homework.data.Note
import com.trubitsyna.homework.data.NotesDataSource

class NotesRepositoryImpl(
    private val notesDataSource: NotesDataSource = NotesDataSource
) : NotesRepository {
    override fun getNotes(): List<Note> {
        return notesDataSource.notesList
    }

    override fun addNotes(text: String) {
        notesDataSource.addNote(text)
    }
}