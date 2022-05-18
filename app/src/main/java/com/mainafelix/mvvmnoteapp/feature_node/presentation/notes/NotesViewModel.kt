package com.mainafelix.mvvmnoteapp.feature_node.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Insert
import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.model.Note
import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel  @Inject constructor(
    private val noteUsedCases:NoteUseCases
):ViewModel(){
    // create a one state wrapper class that represent  the current uistate of the noteSceen
    private val _state = mutableStateOf(NoteState()) // state that contain the  state the ui will observe
   val state: State<NoteState> =_state
    private var deletedRecentlyNote:Note? = null
    fun onEvent(events: NoteEvents){
       when(events) {
           is NoteEvents.Order->{

           }
           is NoteEvents.DeleteNote->{
          viewModelScope.launch {
              noteUsedCases.deleteNotesUseCase(events.note)
              deletedRecentlyNote = events.note
          }
           }
           is NoteEvents.ToggleOrderSection->{
             _state.value = state.value.copy(
                 isOrderSectionVisble=!state.value.isOrderisOrderSectionVisble
             )
           }
           is NoteEvents.RestoreNote->{
       viewModelScope.launch {
       noteUsedCases.addNote(deletedRecentlyNote?:return@launch)
           deletedRecentlyNote= null

       }
           }
       }

    }
}


