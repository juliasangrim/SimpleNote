package com.trubitsyna.homework.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.trubitsyna.homework.data.Note
import com.trubitsyna.homework.domain.AddNoteUseCase
import com.trubitsyna.homework.domain.GetNotesUseCase

class NotesListViewModel(
    private val getNotesUseCase: GetNotesUseCase = GetNotesUseCase(),
    private val addNoteUseCase: AddNoteUseCase = AddNoteUseCase()

) : ViewModel() {

    private val _notesListLiveData = MutableLiveData<List<Note>>()
    val notesListLiveData: LiveData<List<Note>> = _notesListLiveData

    fun onAddClicked(text: String) {
        addNoteUseCase.execute(text)
        getNotes()
    }

    fun getNotes() {
        _notesListLiveData.value = getNotesUseCase.execute().toList()
    }

}