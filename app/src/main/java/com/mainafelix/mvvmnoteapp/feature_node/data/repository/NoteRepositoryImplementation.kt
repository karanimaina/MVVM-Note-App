package com.mainafelix.mvvmnoteapp.feature_node.data.repository

import com.mainafelix.mvvmnoteapp.feature_node.data.data_source.NoteDao
import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.model.Note
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImplementation(
    private  val dao: NoteDao

):NoteDao {
    override fun getNotes(): Flow<List<Note>> {
   return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
       return  dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
           dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }
}