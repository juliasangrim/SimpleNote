package com.trubitsyna.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.trubitsyna.homework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        with(binding) {
//            viewContact.apply {
//                setTitle("Title text")
//                setSubtitle("Subtitle text")
//                setImage(R.drawable.ic_launcher_foreground)
//            }
//        }
    }
}