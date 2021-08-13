package com.ifyezedev.takenote.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ifyezedev.takenote.database.Note
import com.ifyezedev.takenote.ui.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val dataRepository: DataRepository) : ViewModel() {
    private val _readyToNavigate = MutableLiveData<Boolean>()
    val readyToNavigate: LiveData<Boolean>
        get() = _readyToNavigate

    fun saveNote(noteId: Int?, title: String, content: String) {
        if (noteId == null){
            //create a new note in table
            val lastUpdateTime = Calendar.getInstance().timeInMillis
            val note = Note(lastUpdateTime, title, content)

            viewModelScope.launch(Dispatchers.IO) {
                Log.i("NoteFragment", "in save note -VM")
                dataRepository.insertNote(note)
            }
        }
        else {
            //TODO: update existing note in table
        }

        _readyToNavigate.value = true
    }

}