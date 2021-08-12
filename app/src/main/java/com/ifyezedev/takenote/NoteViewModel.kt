package com.ifyezedev.takenote

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(dataRepository: DataRepository) : ViewModel() {
}