package com.ifyezedev.takenote.ui

import androidx.lifecycle.LiveData
import com.ifyezedev.takenote.database.Note
import com.ifyezedev.takenote.database.NoteDao
import javax.inject.Inject
import javax.inject.Singleton

//noteDao is a transitive dependency(interface in this case)
// so we have to tell Hilt how to provide it's instance by using a HiltModule
@Singleton
class DataRepository @Inject constructor(private val noteDao: NoteDao) {
    suspend fun insertNote(note: Note) = noteDao.insertNote(note)

    suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)

    suspend fun updateNote(note: Note) = noteDao.updateNote(note)

    suspend fun getNote(noteId: Int) : Note = noteDao.getNote(noteId)

    fun getAllNotes() : LiveData<List<Note>> = noteDao.getAllNotes()
}