package com.ifyezedev.takenote.ui

import androidx.lifecycle.ViewModel
import com.ifyezedev.takenote.ui.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val dataRepository: DataRepository) : ViewModel() {

}