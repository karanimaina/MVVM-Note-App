package com.mainafelix.mvvmnoteapp.feature_node.data.data_source

import androidx.room.Dao
import androidx.room.Query
import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDa {
    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>>

    suspend fun getNoteById(id:Int):Note?
}