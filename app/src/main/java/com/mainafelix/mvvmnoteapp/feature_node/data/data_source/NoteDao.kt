package com.mainafelix.mvvmnoteapp.feature_node.data.data_source

import androidx.room.*
import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    //returns a flow
    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM note WHERE id =:id" )
    suspend fun getNoteById(id:Int):Note?
// if we call the insert function with an id that already existing in the datanase  then it will just update the existing entry
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note : Note)

    @Delete
    suspend fun deleteNote(note:Note)


}