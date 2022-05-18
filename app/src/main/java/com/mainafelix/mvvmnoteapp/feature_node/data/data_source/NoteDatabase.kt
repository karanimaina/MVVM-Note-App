package com.mainafelix.mvvmnoteapp.feature_node.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.model.Note

@Database(
    // define the tables we have in the database
    entities = [Note::class],
    version = 1
)

abstract class NoteDatabase : RoomDatabase() {
     abstract  val  noteDao:NoteDao

}
