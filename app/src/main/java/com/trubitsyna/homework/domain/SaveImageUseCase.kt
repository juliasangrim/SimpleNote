package com.trubitsyna.homework.domain

import android.net.Uri
import com.trubitsyna.homework.data.repository.ImageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SaveImageUseCase @Inject constructor(
    private val imageRepository: ImageRepository,
) {
    fun execute(uri: Uri): Flow<Uri?> {
        return imageRepository.saveImage(uri)
    }
}