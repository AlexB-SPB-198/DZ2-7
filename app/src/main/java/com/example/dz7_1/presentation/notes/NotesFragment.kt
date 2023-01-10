package com.example.dz7_1.presentation.notes

import android.os.Bundle
import android.provider.Contacts.Intents.UI
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.dz7_1.R
import com.example.dz7_1.databinding.FragmentNotesBinding
import com.example.dz7_1.presentation.utils.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class NotesFragment : Fragment(R.layout.fragment_notes) {

    private val binding by viewBinding(FragmentNotesBinding::bind)
    private  val viewModel by viewModels<NotesViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllNotes()

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.getAllNotesState.collect{state->
                    when(state){
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            Toast.makeText(requireContext(),
                                state.message,Toast.LENGTH_LONG).show()
                        }
                        is UIState.Loading -> {
                            //TODO(show progress)
                        }
                        is UIState.Success ->{
                           // TODO submit list to recycler adapter
                        }
                    }


                }
            }

        }

    }

}