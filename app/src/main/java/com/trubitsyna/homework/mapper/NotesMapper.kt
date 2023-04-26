package com.trubitsyna.homework.mapper

import com.trubitsyna.homework.data.Note
import com.trubitsyna.homework.db.model.NoteEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotesMapper @Inject constructor() {
    fun fromEntityToUiModel(entity: NoteEntity) = Note(
        id = entity.id,
        text = entity.text
    )

    fun fromUiModelToEntity(note: Note) = NoteEntity(
        id = note.id,
        text = note.text
    )
}