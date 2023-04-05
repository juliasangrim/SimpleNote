package com.trubitsyna.homework.fragment2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.trubitsyna.homework.R
import com.trubitsyna.homework.databinding.FragmentSecondBinding

class SecondFragment: Fragment(R.layout.fragment_second) {

    private val binding by viewBinding(FragmentSecondBinding::bind)
    private val args by navArgs<SecondFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textViewText.text = args.text
    }
}