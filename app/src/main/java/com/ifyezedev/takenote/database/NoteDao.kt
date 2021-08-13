package com.ifyezedev.takenote.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {
    @Insert
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Query("SELECT * FROM Notes_Table where noteId = :id")
    suspend fun getNote(id: Int) : Note

    @Query("SELECT * FROM Notes_Table")
    fun getAllNotes() : LiveData<List<Note>>

}