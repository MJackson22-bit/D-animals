package com.example.finalproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.model.Animal

class ProfileAdapter(private val listProfile: MutableList<Animal>, private val onClickListener: (Animal) -> Unit) : RecyclerView.Adapter<ViewHolderProfile>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderProfile {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolderProfile(layoutInflater.inflate(R.layout.item_profile, parent, false))
    }
    override fun onBindViewHolder(holder: ViewHolderProfile, position: Int) {
        val item = listProfile[position]
        holder.render(item, onClickListener)
    }
    override fun getItemCount(): Int = listProfile.size
}