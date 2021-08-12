package com.ifyezedev.takenote.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes_Table")
data class Note (
    @PrimaryKey(autoGenerate = true)
    val noteId : Int,
    val lastUpdateTime : Int,
    val title : String,
    val content : String
    )