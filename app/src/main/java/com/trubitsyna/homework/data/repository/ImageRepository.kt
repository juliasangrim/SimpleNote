package com.trubitsyna.homework.data.repository

import android.net.Uri
import kotlinx.coroutines.flow.Flow

interface ImageRepository {
    fun saveImage(uri: Uri): Flow<Uri?>
    suspend fun deleteImage(uri: Uri)
}