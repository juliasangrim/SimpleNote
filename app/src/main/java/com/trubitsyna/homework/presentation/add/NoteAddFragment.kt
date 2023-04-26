package com.trubitsyna.homework.presentation.add

import android.content.Context
import android.graphics.Bitmap
import android.media.Image
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.Coil
import coil.load
import coil.size.Scale
import com.trubitsyna.homework.R
import com.trubitsyna.homework.databinding.FragmentAddNoteBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext

@AndroidEntryPoint
class NoteAddFragment : Fragment(R.layout.fragment_add_note) {

    private val binding by viewBinding(FragmentAddNoteBinding::bind)
    private val viewModel by viewModels<NoteAddViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        makeAddImageButtonVisible()
        val pickMedia =
            registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
                if (uri != null) {
                    viewModel.saveImageInternalStorage(uri)
                }
            }

        with(binding) {
            floatingActionButtonAdd.setOnClickListener {
                val noteText = editTextAddNote.text.toString()
                if (viewModel.hasNoteImageOrText(noteText)) {
                    viewModel.onAddClicked(editTextAddNote.text.toString())
                    findNavController().popBackStack()
                } else {
                    Toast.makeText(
                        //TODO
                        context, "Add image or text to add note.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            layoutToolbarBack.toolbarAddNote.setNavigationOnClickListener {
                findNavController().popBackStack()
            }
            chipAddImage.setOnClickListener {
                pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            }
            imageViewCancelButton.setOnClickListener {
                imageViewCancelButton.setImageDrawable(null)
                viewModel.deleteImageInternalStorage()
            }
        }
        viewModel.imageLiveData.observe(viewLifecycleOwner) {
            binding.imageViewAddImage.load(it)
            if (it == null) {
                makeAddImageButtonVisible()
            } else {
                makeImageVisible()
            }
        }
    }

    private fun makeImageVisible() {
        with(binding) {
            imageViewCancelButton.visibility = View.VISIBLE
            chipAddImage.visibility = View.INVISIBLE
            imageViewAddImage.visibility = View.VISIBLE
        }
    }

    private fun makeAddImageButtonVisible() {
        with(binding) {
            chipAddImage.visibility = View.VISIBLE
            imageViewAddImage.visibility = View.INVISIBLE
            imageViewCancelButton.visibility = View.INVISIBLE
        }
    }

}