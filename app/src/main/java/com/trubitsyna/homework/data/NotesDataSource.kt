package com.trubitsyna.homework.data

object NotesDataSource {
    val notesList = mutableListOf<Note>()

    fun addNote(text: String) {
        notesList.add(Note(text = text))
    }
}