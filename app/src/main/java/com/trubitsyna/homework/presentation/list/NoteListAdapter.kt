package com.trubitsyna.homework.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.trubitsyna.homework.data.Note
import com.trubitsyna.homework.databinding.ItemNoteBinding
import com.trubitsyna.homework.presentation.list.holder.NoteViewHolder
import javax.inject.Inject

class NoteListAdapter @Inject constructor()
: ListAdapter<Note, NoteViewHolder>(diffUtil) {

    private var onSwipeNote: (Note) -> Unit = {}

    fun setSwipeNoteCallback(callback: (Note) -> Unit) {
        onSwipeNote = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position), onSwipeNote)
    }

    fun onSwipeDeleteItem(position: Int) {
        val currentElem = currentList[position]
        onSwipeNote(currentElem)
        notifyItemRemoved(position)
    }
}

val diffUtil = object : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Note, newItem: Note) = oldItem == newItem
}