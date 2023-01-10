package com.example.dz7_1.presentation.look_notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dz7_1.R
import com.example.dz7_1.databinding.FragmentLookNotesBinding


class LookNotesFragment : Fragment(R.layout.fragment_look_notes) {
    private val binding by viewBinding(FragmentLookNotesBinding::bind)
    lateinit var recyclerView: RecyclerView




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_look_notes, container, false)
        init()
    }

    private fun init() {
        val viewModelLook = ViewModelProvider(this).get(LookNotesViewModel::class.java)
        recyclerView = binding.rvNotes

    }


}