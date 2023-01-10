package com.example.dz7_1.presentation.new_notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dz7_1.R
import com.example.dz7_1.databinding.FragmentNewNotesBinding


class NewNotesFragment : Fragment(R.layout.fragment_new_notes) {
    private val binding by viewBinding(FragmentNewNotesBinding::bind)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_notes, container, false)
        init()
    }

    fun init(){
        val viewModelNotes = ViewModelProvider(this).get(NewNotesViewModel::class.java)
    }


}