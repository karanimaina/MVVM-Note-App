package com.mainafelix.mvvmnoteapp.dependencyInjection

import android.app.Application
import androidx.room.Room
import com.mainafelix.mvvmnoteapp.feature_node.data.data_source.NoteDatabase
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

    return Room.databaseBuilder((app,NoteDatabase::class.java,))

    }

}