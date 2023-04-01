package com.trubitsyna.homework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.trubitsyna.homework.databinding.ViewContactBinding

class DataListAdapter: ListAdapter<DataModel, DataListAdapter.DataViewHolder>(diffUtilCallback) {

    private var onClick: (DataModel) -> Unit = {}

    fun setCallback(callback: (DataModel) -> Unit) {
        this.onClick = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = ViewContactBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class DataViewHolder(
        private val binding: ViewContactBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DataModel) {
            with(binding) {
                textViewHeadline.text = item.title
                textViewSubtitle.text= item.subtitle
                root.setOnClickListener {
                    onClick.invoke(item)
                }
            }
        }
    }
}
val diffUtilCallback = object : DiffUtil.ItemCallback<DataModel>() {
    override fun areItemsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
        return oldItem == newItem
    }

}