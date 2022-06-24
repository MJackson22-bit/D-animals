package com.example.finalproject.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.ItemSearchBinding
import com.example.finalproject.model.Animal

class ViewHolderSearch(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemSearchBinding.bind(view)
    fun render(item: Animal){
        binding.tvName.text = item.name
        binding.tvRace.text = item.race
    }
}