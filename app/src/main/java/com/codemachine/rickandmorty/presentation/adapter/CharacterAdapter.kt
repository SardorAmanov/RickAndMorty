package com.codemachine.rickandmorty.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.codemachine.rickandmorty.R
import com.codemachine.rickandmorty.databinding.CharacterItemBinding
import com.codemachine.rickandmorty.presentation.model.CharacterUI
import javax.inject.Inject

class CharacterAdapter @Inject constructor(
    private val context: Context) :
    PagingDataAdapter<CharacterUI, CharacterAdapter.CharacterViewHolder>(CharacterComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CharacterViewHolder(
            CharacterItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class CharacterViewHolder(private val binding: CharacterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("ResourceAsColor")
        fun bind(item: CharacterUI) = with(binding) {
            characterImageView.load(item.image) {
                crossfade(true)
                placeholder(R.drawable.ic_launcher_background)
                transformations(CircleCropTransformation())
            }
            characterNameTextView.text = item.name
            locationTextView.text = item.getCharacterFrom()
            statusView.setBackgroundColor(item.getStatusColor())
            statusTextView.text = item.getCharacterStatus(context = context)
        }
    }

    object CharacterComparator : DiffUtil.ItemCallback<CharacterUI>() {
        override fun areItemsTheSame(oldItem: CharacterUI, newItem: CharacterUI) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: CharacterUI, newItem: CharacterUI) =
            oldItem == newItem
    }
}