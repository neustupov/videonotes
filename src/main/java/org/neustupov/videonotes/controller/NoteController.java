package org.neustupov.videonotes.controller;

import org.neustupov.videonotes.model.Note;
import org.neustupov.videonotes.repo.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:8082"})
@RestController
@RequestMapping("/api")
public class NoteController {

  private NoteRepository noteRepository;

  @Autowired
  public NoteController(NoteRepository noteRepository) {
    this.noteRepository = noteRepository;
  }

  @PostMapping("/notes")
  public ResponseEntity<Note> createSticker(@RequestBody Note note) {
    try {
      Note _note = noteRepository.save(note);
      return new ResponseEntity<>(_note, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
