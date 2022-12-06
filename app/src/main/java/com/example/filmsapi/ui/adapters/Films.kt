package com.example.filmsapi.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.filmsapi.base.BaseDiffUtilItemCallback
import com.example.filmsapi.databinding.FilmsItemBinding
import com.example.filmsapi.models.FilmsModel
import com.example.filmsapi.ui.fragments.films.FilmsFragment

class FilmsAdapter(private val onItemClickListener: FilmsFragment) :
    ListAdapter<FilmsModel, FilmsAdapter.FilmsViewHolder>(
        BaseDiffUtilItemCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FilmsViewHolder(
        FilmsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        getItem(position).let { holder.onBind(it) }
    }

    inner class FilmsViewHolder(private val binding: FilmsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: FilmsModel) {
            binding.TextViewTitle.text = model.title
            binding.ImageViewFilms.load(model.image)
            binding.TextViewDescription.text = model.description
            binding.TextViewProducer.text = model.producer
            itemView.setOnClickListener {
                onItemClickListener.onItemClick(model)
            }
        }
    }
}