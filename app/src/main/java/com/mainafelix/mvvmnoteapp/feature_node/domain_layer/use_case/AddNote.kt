package com.mainafelix.mvvmnoteapp.feature_node.domain_layer.use_case

import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.model.Note
import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.repository.NodeRepository

class AddNote (
    private val repository: NodeRepository
        ){
    suspend operator fun invoke(note: Note){
        if (note.title.isBlank()){

        }
      repository.insertNode(note)
    }
}