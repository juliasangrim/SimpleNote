package com.trubitsyna.homework.presentation.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trubitsyna.homework.domain.AddNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NoteAddViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase
): ViewModel() {

    fun onAddClicked(text: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                addNoteUseCase.execute(text)
            }
        }
    }

}