package com.trubitsyna.homework.data.repository

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.core.net.toFile
import androidx.core.net.toUri
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import java.io.ByteArrayInputStream
import java.io.File
import java.nio.file.CopyOption
import java.nio.file.Files
import java.nio.file.StandardCopyOption
import java.util.UUID
import javax.inject.Inject

class ImageRepository @Inject constructor(
    @ApplicationContext val context: Context
) {
    fun saveImage(uri: Uri): Flow<Uri> = flow {
        val imageFileInternalStorage =
            File(context.filesDir, UUID.randomUUID().toString())
        if (!imageFileInternalStorage.exists()) {
            context.contentResolver.openInputStream(uri).use { input ->
                imageFileInternalStorage.outputStream().use { output ->
                    input?.copyTo(output)
                }
            }
        }
        val newUri = imageFileInternalStorage.toUri()
        Log.i("saveImage", newUri.toString())
        emit(newUri)
    }

    suspend fun deleteImage(uri: Uri) {
        val imageFileInternalStorage = uri.toFile()
        val isDeleted = imageFileInternalStorage.delete()
        if (isDeleted) {
            Log.i("FileOperations", "File deleted!")
        } else {
            Log.e("FileOperations", "File cannot be deleted!")
        }
    }

}