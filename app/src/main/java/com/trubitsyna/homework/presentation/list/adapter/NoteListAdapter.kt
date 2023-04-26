package com.trubitsyna.homework.presentation.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.trubitsyna.homework.data.Note
import com.trubitsyna.homework.databinding.ItemNoteImageWithTextBinding
import com.trubitsyna.homework.databinding.ItemNoteTextBinding
import com.trubitsyna.homework.presentation.list.holder.ImageTextNoteViewHolder
import com.trubitsyna.homework.presentation.list.holder.TextNoteViewHolder
import com.trubitsyna.homework.presentation.list.model.ViewHolderType
import javax.inject.Inject

class NoteListAdapter @Inject constructor() : ListAdapter<Note, ViewHolder>(diffUtil) {
    private var onSwipeNote: (Note) -> Unit = {}

    fun setSwipeNoteCallback(callback: (Note) -> Unit) {
        onSwipeNote = callback
    }

    override fun getItemViewType(position: Int): Int {
        val elem = getItem(position)
        return if (isTextNote(elem)) {
            ViewHolderType.ONLY_TEXT_TYPE.ordinal
        } else {
            ViewHolderType.IMAGE_WITH_TEXT_TYPE.ordinal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        when (viewType) {
            ViewHolderType.IMAGE_WITH_TEXT_TYPE.ordinal -> {
                ImageTextNoteViewHolder(
                    ItemNoteImageWithTextBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> {
                TextNoteViewHolder(
                    ItemNoteTextBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            ViewHolderType.IMAGE_WITH_TEXT_TYPE.ordinal -> {
                (holder as ImageTextNoteViewHolder).bind(getItem(position), onSwipeNote)
            }

            else -> {
                (holder as TextNoteViewHolder).bind(getItem(position), onSwipeNote)
            }
        }
    }

    fun onSwipeDeleteItem(position: Int) {
        val currentElem = currentList[position]
        onSwipeNote(currentElem)
        notifyItemRemoved(position)
    }

    private fun isTextNote(note: Note) = note.text.isNotBlank() && note.imageUri == null
}


val diffUtil = object : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Note, newItem: Note) = oldItem == newItem
}