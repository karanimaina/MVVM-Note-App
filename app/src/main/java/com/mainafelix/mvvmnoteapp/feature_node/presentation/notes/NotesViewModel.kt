package com.mainafelix.mvvmnoteapp.feature_node.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Insert
import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.model.Note
import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.use_case.NoteUseCases
import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.util.NoteOrder
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
               //checking if the class of the first order type is the same as the class of the second order type
             if (state.value.noteOrder::class==events.noteOrder::class && state.value.noteOrder.orderType ==events.noteOrder.orderType ){
                 return
                 }
               getNotes(events.noteOrder)
           }
           is NoteEvents.DeleteNote->{

          viewModelScope.launch {
              noteUsedCases.deleteNotesUseCase(events.note)
              deletedRecentlyNote = events.note
          }
           }
//           is NoteEvents.ToggleOrderSection->{
//             _state.value = state.value.copy(
//                 isOrderSectionVisble=!state.value.isOrderisOrderSectionVisble
//             )
//           }
           is NoteEvents.RestoreNote->{
       viewModelScope.launch {

       noteUsedCases.addNote(deletedRecentlyNote?:return@launch)
           deletedRecentlyNote= null
       }
           }
       }

    }
//returns a flow fromm the database
    private fun getNotes(noteOrder: NoteOrder) {
        noteUsedCases.getNotesUseCase(noteOrder)

    }
}


