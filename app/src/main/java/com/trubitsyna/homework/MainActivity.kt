package com.trubitsyna.homework

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.trubitsyna.homework.databinding.ActivityMainBinding
import com.trubitsyna.homework.second_activity.SecondActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonAction.setOnClickListener{
            val text = binding.editText.text.toString()
            startActivity(SecondActivity.createIntent(this, text))
        }
    }
}