package com.mainafelix.mvvmnoteapp.feature_node.presentation.notes.components

import androidx.lifecycle.ViewModel
import androidx.room.Insert
import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotesViewModel  @Inject constructor(
    private val noteUsedCases:NoteUseCases
):ViewModel()
// create a one state wrapper class that represent  the current uistate of the noteSceen
