package com.trubitsyna.homework.presentation.list

import androidx.recyclerview.widget.DiffUtil
import com.trubitsyna.homework.data.Note

object NoteDiffUtil: DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Note, newItem: Note) = oldItem == newItem
}