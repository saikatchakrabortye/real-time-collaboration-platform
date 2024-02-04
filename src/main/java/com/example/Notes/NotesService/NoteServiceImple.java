package com.example.Notes.NotesService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*This class provides the actual implementation for the NoteService Interface */
@Service
public class NoteServiceImple implements NoteService {
    @Autowired
    private NotesRepository notesRepository;

    @Override
    public Note saveNote(Note note)
    {
        return notesRepository.save(note);
    }
    @Override
    public ArrayList<Note> getAll()
    {
        ArrayList<Note> nlist=(ArrayList<Note>)notesRepository.findAll();
        return nlist;
    }
    @Override
    public ArrayList<Note> getAllByUsername(String username)
    {
        ArrayList<Note> nlist=(ArrayList<Note>)notesRepository.findAllByUsername(username);
        //ArrayList<Note> nlist=(ArrayList<Note>)notesRepository.findAll();
        return nlist;
    }

    public void deleteNote(Note note)
    {
        notesRepository.delete(note);
    }
}
