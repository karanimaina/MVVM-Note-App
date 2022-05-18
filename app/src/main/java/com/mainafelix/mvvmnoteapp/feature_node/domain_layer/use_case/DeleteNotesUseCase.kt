package com.mainafelix.mvvmnoteapp.feature_node.domain_layer.use_case

import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.model.Note
import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.repository.NodeRepository

class DeleteNotesUseCase(
    private  val repository: NodeRepository
) {
    suspend operator fun invoke(note: Note){
        repository.deleteNode(note)
    }
}