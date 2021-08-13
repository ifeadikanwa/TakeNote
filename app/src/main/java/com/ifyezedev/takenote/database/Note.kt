package com.ifyezedev.takenote.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes_Table")
data class Note (
    val lastUpdateTime : Long,
    val title : String,
    val content : String,
    @PrimaryKey(autoGenerate = true) val noteId : Int = 0
    )