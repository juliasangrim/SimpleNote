package com.trubitsyna.homework

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.trubitsyna.homework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val listAdapter by lazy {
        DataListAdapter()
    }

    private val dataList = mutableListOf<DataModel>(
        DataModel(title = "Title 1", subtitle = "Subtitle 1"),
        DataModel(title = "Title 2", subtitle = "Subtitle 2"),
        DataModel(title = "Title 3", subtitle = "Subtitle 3"),
        DataModel(title = "Title 4", subtitle = "Subtitle 4")
    )

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonAdd.setOnClickListener {
            dataList.add(DataModel(title = "Title 4", subtitle = "Subtitle 4"))
            listAdapter.submitList(dataList.toList())
        }

        binding.buttonDelete.setOnClickListener {
            dataList.removeLastOrNull()
            listAdapter.submitList(dataList.toList())
        }
        listAdapter.setCallback {model ->
            Toast.makeText(this, model.title, Toast.LENGTH_SHORT ).show()
        }
        binding.recyclerView.adapter = listAdapter

    }
}