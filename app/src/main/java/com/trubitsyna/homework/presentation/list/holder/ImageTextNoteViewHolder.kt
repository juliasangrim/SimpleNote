package com.trubitsyna.homework.presentation.list.holder

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.trubitsyna.homework.data.Note
import com.trubitsyna.homework.databinding.ItemNoteImageWithTextBinding

class ImageTextNoteViewHolder(
    private val binding: ItemNoteImageWithTextBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Note, onSwipeNote: (Note) -> Unit) {
        with(binding) {
            root.setOnLongClickListener {
                onSwipeNote(item)
                false
            }
            if (item.text.isNotBlank()) {
                textViewNoteText.text = item.text
            } else {
                textViewNoteText.visibility = View.GONE
            }
            imageViewNoteImage.load("file://" + item.imageUri)
        }

    }
}