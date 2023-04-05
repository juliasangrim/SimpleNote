package com.trubitsyna.homework.fragment1

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.trubitsyna.homework.R
import com.trubitsyna.homework.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {

    companion object {
        const val ARG_TEXT_KEY = "text"
    }

    private val binding by viewBinding(FragmentFirstBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAdd.setOnClickListener {
            val text = binding.editText.text.toString()
            findNavController().navigate(
                FirstFragmentDirections.actionFirstFragmentToSecondFragment(text)
            )
        }
    }
}