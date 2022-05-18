package com.mainafelix.mvvmnoteapp.feature_node.domain_layer.repository

import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.model.Note
import kotlinx.coroutines.flow.Flow

interface NodeRepository {
    // the repository takes care of the data from the data sources
    //is that the functions that are present in the dao Interface are included in yhis repository class
         fun getNotes():Flow<List<Note>>
         suspend fun  getNotesById(id:Int):Note?
         suspend fun insertNode(note:Note)
         suspend fun  deleteNode(note : Note)


}