package com.ifyezedev.takenote

import com.ifyezedev.takenote.database.NoteDao
import javax.inject.Inject
import javax.inject.Singleton

//noteDao is a transitive dependency(interface in this case)
// so we have to tell Hilt how to provide it's instance by using a HiltModule
@Singleton
class DataRepository @Inject constructor(noteDao: NoteDao) {
}