package com.trubitsyna.homework.data.repository

import android.net.Uri
import com.trubitsyna.homework.data.Note
import com.trubitsyna.homework.db.NotesDAO
import com.trubitsyna.homework.db.model.NoteEntity
import com.trubitsyna.homework.mapper.NotesMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.net.URI
import java.net.URL
import javax.inject.Inject

class NotesRepositoryImpl @Inject constructor(
    private val notesDAO: NotesDAO,
    private val mapper: NotesMapper
) : NotesRepository {
    override fun getNotes(): Flow<List<Note>> {
        return notesDAO.getNotes().map { list ->
            list.map { item ->
                mapper.fromEntityToUiModel(item)
            }
        }
    }

    override suspend fun addNotes(note: Note) {
        notesDAO.addNote(
           mapper.fromUiModelToEntity(note)
        )
    }

    override suspend fun deleteNotes(note: Note) {
        notesDAO.deleteNote(mapper.fromUiModelToEntity(note))
    }
}