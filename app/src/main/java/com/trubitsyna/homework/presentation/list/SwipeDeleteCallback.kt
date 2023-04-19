package com.trubitsyna.homework.presentation.list
//for the future

//import androidx.recyclerview.widget.ItemTouchHelper
//import androidx.recyclerview.widget.RecyclerView
//import com.trubitsyna.homework.databinding.ItemDeleteNoteBinding
//
//class SwipeDeleteCallback(
//    private val adapter: NoteListAdapter
//) : ItemTouchHelper.Callback() {
//    override fun getMovementFlags(
//        recyclerView: RecyclerView,
//        viewHolder: RecyclerView.ViewHolder
//    ): Int {
//        val dragFlags = 0
//        val swipeFlags = ItemTouchHelper.RIGHT
//        return makeMovementFlags(dragFlags, swipeFlags)
//    }
//
//    override fun onMove(
//        recyclerView: RecyclerView,
//        viewHolder: RecyclerView.ViewHolder,
//        target: RecyclerView.ViewHolder
//    ): Boolean {
//        return false
//    }
//
//    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//        val position = viewHolder.adapterPosition
//        adapter.onSwipeDeleteItem(position)
//    }
//}