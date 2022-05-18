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
        TODO("Not yet implemented")
    }

    override suspend fun insertNote(note: Note) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNote(note: Note) {
        TODO("Not yet implemented")
    }
}