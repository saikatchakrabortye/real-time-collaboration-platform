package com.example.Notes.NotesService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Notes.SendingPacket;
import com.example.Notes.UserService.User;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class NotesController {

     

    //@Autowired 
   // private NotesRepository notesRepository;

    @Autowired //Using the note service I created using Autowired. Jekhane jekhane service ta lagbe use it everywhere like this.
    private NoteService noteService;

    @Autowired //To make use of the current session and access the objects in it in this class.
    private HttpSession session;

    @Autowired
    public NotesController(NoteService noteService, HttpSession session) // constructor
    {
        this.noteService=noteService;
        this.session=session;
    }

    

    ArrayList<Note> list=new ArrayList<Note>();

    
    
    @PostMapping("/addnote")
	public String noteSubmit(@ModelAttribute Note note, Model model) {
    //model.addAttribute("note", note);
    /*Retriving the currentUser object from the session into user and then using it */
    User user=(User)session.getAttribute("currentUser");
    String name=user.getUsername();
    
    String sharedBy="no one";
    
    Note newNote=new Note(note.title, note.description, name, sharedBy);
    //list.add(newNote);
    noteService.saveNote(newNote);
    //notesRepository.save(newNote);
    return "redirect:/viewall";
  }

  @GetMapping("/viewall")
  public String viewAllNotes(Model model)
  {
        //]ArrayList<Note> nlist=(ArrayList<Note>)notesRepository.findAll();
        /*Retriving the currentUser object from the session into user and then using it */

    User user=(User)session.getAttribute("currentUser");
    if (user==null)
    {
        return "redirect:/u/signin";
    }
        String name=user.getUsername();
        ArrayList<Note> nlist=noteService.getAllByUsername(name);
        list=nlist;
        model.addAttribute("list", nlist);
        /*For creating a new note*/ 
        model.addAttribute("note", new Note());
        model.addAttribute("nameOfUser", name);
    
    return "note/allnotes";
  }
  @GetMapping("/viewallnotes")
  public String viewOfUser(Model model)
  {
        //]ArrayList<Note> nlist=(ArrayList<Note>)notesRepository.findAll();
        /*Retriving the currentUser object from the session into user and then using it */
    User user=(User)session.getAttribute("currentUser");
    if (user==null)
    {
        return "redirect:/u/signin";
    }
        ArrayList<Note> nlist=noteService.getAll();
        list=nlist;
        model.addAttribute("list", nlist);
        /*For creating a new note*/ 
        model.addAttribute("note", new Note());
    
    return "note/allnotes";
  }
  @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") int id) //RequestParam annotation maps id parameter from http request into id parameter of deleteNode method 
    {

        // Remove the note at the specified index

        //list.remove(id);
        Note newNote=list.get(id);
        noteService.deleteNote(newNote);
       // notesRepository.delete(newNote);

        // Return the view name
        return "redirect:/viewall";
    }
    @PostMapping("/update")
    public String updateNote(@ModelAttribute Note note, @RequestParam("id") int id)
    {
        /*Retriving the currentUser object from the session into user and then using it */
    User user=(User)session.getAttribute("currentUser");
        // Get the note at the specified index
        Note noteToUpdate = list.get(id);

        // Update the note with the new values
        noteToUpdate.setTitle(note.getTitle());
        noteToUpdate.setDescription(note.getDescription());
        noteToUpdate.setUsername(user.getUsername());

        //notesRepository.save(noteToUpdate);
        noteService.saveNote(noteToUpdate);

     return "redirect:/viewall";   
    }
    @PostMapping("/logout")
    public String logoutCurrentUser()
    {
        session.invalidate(); // Closing the Http Session
        return "redirect:/u/signin";
    }
    

}
