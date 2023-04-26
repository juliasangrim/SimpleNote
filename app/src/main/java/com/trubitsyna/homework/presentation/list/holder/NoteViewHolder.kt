package com.trubitsyna.homework.presentation.list.holder

import androidx.recyclerview.widget.RecyclerView
import com.trubitsyna.homework.data.Note
import com.trubitsyna.homework.databinding.ItemNoteBinding

class NoteViewHolder(
    private val binding: ItemNoteBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Note, onSwipeNote: (Note) -> Unit) {
        with(binding) {
            root.setOnLongClickListener {
                onSwipeNote(item)
                false
            }
            textView.text = item.text
        }

    }
}