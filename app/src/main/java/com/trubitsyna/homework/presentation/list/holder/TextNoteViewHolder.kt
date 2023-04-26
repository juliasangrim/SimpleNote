package com.trubitsyna.homework.presentation.list.holder

import androidx.recyclerview.widget.RecyclerView
import com.trubitsyna.homework.data.Note
import com.trubitsyna.homework.databinding.ItemNoteTextBinding

class TextNoteViewHolder(
    private val binding: ItemNoteTextBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Note, onSwipeNote: (Note) -> Unit) {
        with(binding) {
            root.setOnLongClickListener {
                onSwipeNote(item)
                false
            }
            textViewNoteText.text = item.text
        }

    }
}