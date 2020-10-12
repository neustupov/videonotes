package org.neustupov.videonotes.controller;

import java.util.Optional;
import org.neustupov.videonotes.model.Note;
import org.neustupov.videonotes.repo.NoteRepository;
import org.neustupov.videonotes.service.NoteService;
import org.neustupov.videonotes.to.NoteTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:8082"})
@RestController
@RequestMapping("/api")
public class NoteController {

  private NoteService noteService;
  private NoteRepository noteRepository;

  @Autowired
  public NoteController(NoteRepository noteRepository, NoteService noteService) {
    this.noteRepository = noteRepository;
    this.noteService = noteService;
  }

  @PostMapping("/notes")
  public ResponseEntity<Note> createSticker(@RequestBody NoteTo noteTo) {
    try {
      Note _note = noteService.save(noteTo);
      return new ResponseEntity<>(_note, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/notes/{id}")
  public ResponseEntity<Note> updateNote(@PathVariable("id") long id,
      @RequestBody Note note) {
    Optional<Note> noteData = noteRepository.findById(id);

    if (noteData.isPresent()) {
      Note _note = noteData.get();
      _note.setDescription(note.getDescription());
      return new ResponseEntity<>(noteRepository.save(_note), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
