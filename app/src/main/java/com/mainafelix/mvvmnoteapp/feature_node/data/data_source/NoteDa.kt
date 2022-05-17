package com.mainafelix.mvvmnoteapp.feature_node.data.data_source

import androidx.room.Dao
import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDa {
    fun getNotes(): Flow<List<Note>>
}