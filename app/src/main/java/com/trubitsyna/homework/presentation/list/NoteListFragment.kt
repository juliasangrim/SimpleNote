package com.trubitsyna.homework.presentation.list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.trubitsyna.homework.R
import com.trubitsyna.homework.databinding.FragmentNotesListBinding

class NoteListFragment: Fragment(R.layout.fragment_notes_list) {

    companion object {
        private const val MOCK = "Note text that resizes the card vertically to fit itself. It can be very long, but let’s settle on 180 characters as the limit"
    }

    private val binding by viewBinding(FragmentNotesListBinding::bind)
    private val viewModel by viewModels<NotesListViewModel>()

    private val listAdapter = NoteListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getNotes()
        with(binding) {
            toolbar.setNavigationOnClickListener {
                findNavController().popBackStack()
            }

            recyclerView.apply {
                layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
                adapter = listAdapter.apply {
                    setCallback { note ->
                        Toast.makeText(requireContext(), note.text, Toast.LENGTH_SHORT).show()
                    }
                }

            }

            floatingActionButton.setOnClickListener {
                viewModel.onAddClicked(MOCK)
            }

        }
        viewModel.notesListLiveData.observe(viewLifecycleOwner) {
            listAdapter.submitList(it)
        }
    }

}