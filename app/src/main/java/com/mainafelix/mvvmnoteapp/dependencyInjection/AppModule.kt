package com.mainafelix.mvvmnoteapp.dependencyInjection

import android.app.Application
import androidx.room.Room
import com.mainafelix.mvvmnoteapp.feature_node.data.data_source.NoteDatabase
import com.mainafelix.mvvmnoteapp.feature_node.data.repository.NoteRepositoryImplementation
import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.repository.NodeRepository
import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.use_case.DeleteNotesUseCase
import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.use_case.GetNotesUseCase
import com.mainafelix.mvvmnoteapp.feature_node.domain_layer.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)//for installing in the singleton componet
object AppModule {
//create an instance of the room Database
    @Provides
    @Singleton
// take the application context
    fun provideNoteDatabase(app:Application):NoteDatabase{
    return Room.databaseBuilder(app,NoteDatabase::class.java, NoteDatabase.DATABASE_NAME).build()
    }

    @Provides
    @Singleton
    // we us ethe  Note database to help re trieve the database dao
    // returns note implementation that will be used  to return  the note impplementaion
    fun provideNoteRepository(db:NoteDatabase): NoteRepositoryImplementation {
        return NoteRepositoryImplementation(db.noteDao)
    }
    @Provides
    @Singleton
 fun ProvidesNoteRepository(repository: NodeRepository):NoteUseCases{
     return  NoteUseCases(
        getNotesUseCase = GetNotesUseCase(repository),
         deleteNotesUseCase = DeleteNotesUseCase(repository
     )
 }



}