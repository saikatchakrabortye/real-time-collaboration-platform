package com.example.Notes.NotesService;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// This is the description of a note object
@Entity
public class Note{
        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    String title;
    String description;
    String username;
    String sharedBy;

    public Note(String title, String description, String username, String sharedBy) {
        this.title = title;
        this.description = description;
        this.username=username;
        this.sharedBy="none";
    }
    public Note()
    {
        this.title="";
        this.description="";
        this.username="";
        this.sharedBy="none";
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String note_body) {
        this.description = note_body;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getSharedBy() {
        return sharedBy;
    }
    public void setSharedBy(String sharedBy) {
        this.sharedBy = sharedBy;
    }
    

}