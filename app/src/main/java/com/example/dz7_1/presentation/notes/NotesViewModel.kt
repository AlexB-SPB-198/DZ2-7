package com.example.dz7_1.presentation.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dz7_1.domain.model.Note
import com.example.dz7_1.domain.usecase.GetAllNoteUseCase
import com.example.dz7_1.domain.utils.Resource
import com.example.dz7_1.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val getAllNoteUseCase: GetAllNoteUseCase
):ViewModel() {

    private val _getAllNotesState = MutableStateFlow<UIState<List<Note>>>(UIState.Empty())
    val getAllNotesState = _getAllNotesState.asStateFlow()

    fun getAllNotes(){
        viewModelScope.launch {
            getAllNoteUseCase.getAllNote().collect{
                when(it) {
                    is Resource.Loading -> {
                        _getAllNotesState.value = UIState.Loading()

                    }
                    is Resource.Error ->{
                        _getAllNotesState.value = UIState.Error(it.message!!)

                    }
                    is Resource.Success ->{
                        if (it.data!=null)
                        _getAllNotesState.value = UIState.Success(it.data)

                    }

                }
            }
        }


    }
}
