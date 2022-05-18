package com.mainafelix.mvvmnoteapp.feature_node.presentation.notes

import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.model.Note
import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.util.NoteOrder
import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.util.OrderType

class NoteState (
    val notes:List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible:Boolean = false

){

}