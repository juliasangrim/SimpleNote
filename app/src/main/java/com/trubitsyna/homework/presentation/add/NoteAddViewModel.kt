package com.trubitsyna.homework.presentation.add

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.Coil
import com.trubitsyna.homework.data.Note
import com.trubitsyna.homework.domain.AddNoteUseCase
import com.trubitsyna.homework.domain.DeleteImageUseCase
import com.trubitsyna.homework.domain.SaveImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import javax.inject.Inject

@HiltViewModel
class NoteAddViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase,
    private val saveImageUseCase: SaveImageUseCase,
    private val deleteImageUseCase: DeleteImageUseCase,
) : ViewModel() {

    private val _imageLiveData = MutableLiveData<Uri?>()
    val imageLiveData: LiveData<Uri?> = _imageLiveData

    fun saveImageInternalStorage(imageUri: Uri) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                saveImageUseCase.execute(imageUri).collect { it ->
                    _imageLiveData.postValue(it)
                }
            }
        }
    }

    fun deleteImageInternalStorage() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _imageLiveData.value?.let { deleteImageUseCase.execute(it) }
                _imageLiveData.postValue(null)
            }
        }
    }

    fun onAddClicked(text: String) {
        Log.i("viewModel", _imageLiveData.value.toString())
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                addNoteUseCase.execute(
                    Note(
                        id = 0,
                        text = text,
                        imageUri = _imageLiveData.value
                    )
                )
            }
        }
    }

    fun hasNoteImageOrText(text: String) =
        text.isNotEmpty() || _imageLiveData.value != null

}