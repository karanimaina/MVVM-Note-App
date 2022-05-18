package com.mainafelix.mvvmnoteapp.feature_node.domain_layer.use_case

import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.model.Note
import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.model.invalidNoteExceptioon
import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.repository.NodeRepository

class AddNote (
    private val repository: NodeRepository
        ){
    @Throws(invalidNoteExceptioon::class)
    suspend operator fun invoke(note: Note){
        if (note.title.isBlank()){
        throw invalidNoteExceptioon("the title of the note can be empty")
        }
        if (note.content.isBlank()){
            throw invalidNoteExceptioon("the content of the note can be empty")
        }
      repository.insertNode(note)
    }
}