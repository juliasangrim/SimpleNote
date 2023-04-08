package com.trubitsyna.homework.data.repository

import com.trubitsyna.homework.data.Note

interface NotesRepository {
    fun getNotes(): List<Note>
    fun addNotes(text: String)
}