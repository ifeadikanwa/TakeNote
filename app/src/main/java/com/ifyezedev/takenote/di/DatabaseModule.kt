package com.ifyezedev.takenote.di

import android.content.Context
import androidx.room.Room
import com.ifyezedev.takenote.database.NoteDao
import com.ifyezedev.takenote.database.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    //here we tell Hilt how to provide the noteDao
    //Also note that noteDatabase is a transitive dependency(abstract class in this case) so
    //we have to tell Hilt how to provide it's instance with another HiltModule
    @Singleton
    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase) : NoteDao {
        return noteDatabase.noteDao
    }

    //here we tell Hilt how to provide the noteDatabase
    //we use singleton to tell it to return the same instance everytime
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): NoteDatabase {
        return Room.databaseBuilder(
            appContext,
            NoteDatabase::class.java,
            "note_database"
        ).fallbackToDestructiveMigration()
            .build()
    }
}