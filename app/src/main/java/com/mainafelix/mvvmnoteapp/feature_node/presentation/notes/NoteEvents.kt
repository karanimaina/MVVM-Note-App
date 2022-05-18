package com.mainafelix.mvvmnoteapp.feature_node.presentation.notes

import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.model.Note
import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.util.NoteOrder

sealed class NoteEvents{
    data class Order(val noteOrder: NoteOrder):NoteEvents()
    data class DeleteNote(val note:Note):NoteEvents()
    object RestoreNote:NoteEvents()
    object ToggleOrderSection:NoteEvents()

}
