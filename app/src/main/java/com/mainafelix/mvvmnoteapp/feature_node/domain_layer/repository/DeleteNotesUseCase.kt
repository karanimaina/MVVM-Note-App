package com.mainafelix.mvvmnoteapp.feature_node.domain_layer.repository

import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.model.Note

class DeleteNotesUseCase(
    private  val repository: NodeRepository) {
    suspend operator fun invoke(note: Note){
        repository.deleteNode(note)

    }
}