package com.mainafelix.mvvmnoteapp.feature_node.domain_layer.use_case

import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.model.Note
import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.repository.NodeRepository
import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.util.NoteOrder
import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.util.OrderType
import kotlinx.coroutines.flow.map

// the view model commprise of the business logic that is they represent the action the user does, hey are named as they do
class GetNotesUseCase (
    private val repository: NodeRepository
        ){
    //use cases should only have one public function
    operator fun invoke(noteOrder: NoteOrder =NoteOrder.Date(OrderType.Descending) ):kotlinx.coroutines.flow.Flow<List<Note>>{
        // flows ae used to provide multiple values as opposed to suspend functions which only generate a single value
        // the returned values  are of the same values
        return repository.getNotes().map {  notes ->
            when (noteOrder.orderType){
                is OrderType.Ascending ->{
                    when(noteOrder){
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy {it.timeStamp  }
                        is NoteOrder.Color ->notes.sortedBy { it.color }

                    }

                }
                is OrderType.Descending -> {
                    when(noteOrder){
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy {it.timeStamp  }
                        is NoteOrder.Color ->notes.sortedBy { it.color }

                    }

                }
            }
        }
    }

}