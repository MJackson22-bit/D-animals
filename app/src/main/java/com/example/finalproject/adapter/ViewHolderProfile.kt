package com.example.finalproject.adapter

import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.databinding.ItemProfileBinding
import com.example.finalproject.model.Animal

class ViewHolderProfile(view: View) : RecyclerView.ViewHolder(view),  PopupMenu.OnMenuItemClickListener {
    private val binding = ItemProfileBinding.bind(view)
    fun render(item: Animal, onClickListener: (Animal) -> Unit){
        binding.tvName.text = item.name
        binding.tvRace.text = item.race
        itemView.setOnClickListener {
            onClickListener(item)
        }
        binding.ivOpenMenu.setOnClickListener {
            PopupMenu(binding.ivOpenMenu.context, it).apply {
                setOnMenuItemClickListener(this@ViewHolderProfile)
                inflate(R.menu.menu_profile)
                show()
            }
        }
    }

    override fun onMenuItemClick(menuItem: MenuItem?): Boolean {
        return when(menuItem?.itemId){
            R.id.menuCompartir -> {
                Toast.makeText(binding.ivOpenMenu.context, "Compartir", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menuEditar -> {
                Toast.makeText(binding.ivOpenMenu.context, "Editar", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menuEliminar -> {
                Toast.makeText(binding.ivOpenMenu.context, "Eliminar", Toast.LENGTH_SHORT).show()
                true
            }
            else -> false
        }
    }
}