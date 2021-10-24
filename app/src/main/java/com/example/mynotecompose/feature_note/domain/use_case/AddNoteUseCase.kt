package com.example.mynotecompose.feature_note.domain.use_case

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.example.mynotecompose.NoteApp
import com.example.mynotecompose.R
import com.example.mynotecompose.feature_note.domain.model.InvalidNoteException
import com.example.mynotecompose.feature_note.domain.model.Note
import com.example.mynotecompose.feature_note.domain.repository.NoteRepository
import dagger.hilt.android.internal.Contexts.getApplication
import dagger.hilt.android.qualifiers.ApplicationContext


class AddNoteUseCase(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of the note can't be empty")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("The content of the note can't be empty")
        }
        repository.insertNote(note)
    }
}