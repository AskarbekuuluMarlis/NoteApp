package com.example.noteapp.interfaces

import com.example.noteapp.data.models.NoteModel

interface OnItemClick {
    fun onClick(noteModel: NoteModel)
}