package com.example.dz7_1.presentation.look_notes

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dz7_1.databinding.ItemNotesBinding

class NotesAdapter:RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    class NotesViewHolder(private val binding: ItemNotesBinding)
        :RecyclerView.ViewHolder(binding.root){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}