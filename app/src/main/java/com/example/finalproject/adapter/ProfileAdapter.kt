package com.example.finalproject.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.model.Animal

class ProfileAdapter(val listProfile: MutableList<Animal>, val onClickListener: (Animal) -> Unit) : RecyclerView.Adapter<ViewHolderProfile>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderProfile {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolderProfile, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}