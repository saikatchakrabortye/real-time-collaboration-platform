package com.example.Notes.NotesService;

import java.util.ArrayList;

/* Note Service interface is created. This is an interface between the NotesRepository (CrudRepository) & The NotesController.
 * The Actual Implementation of this interface in provided in NoteServiceImple
 * Here we are defining the interface NoteService
*/
public interface NoteService {
    /*Only the method name, its type and its parameters are defined here */
    Note saveNote(Note note);
    ArrayList<Note> getAll();
    ArrayList<Note> getAllByUsername(String username);
    void deleteNote(Note note);

}
