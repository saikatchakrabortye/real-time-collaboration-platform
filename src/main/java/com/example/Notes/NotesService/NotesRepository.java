package com.example.Notes.NotesService;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends JpaRepository<Note, Integer>{
    /*JPQL query syntax */
@Query("SELECT n FROM Note n WHERE username = ?1") //The `?1` placeholder in the query is replaced with the value of the `username` parameter when the method is called.
    List<Note> findAllByUsername(String username);
}
