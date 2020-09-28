package org.neustupov.videonotes.controller;

import java.util.Map;
import org.neustupov.videonotes.model.Note;
import org.neustupov.videonotes.repo.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NoteController {

  @Autowired
  private NoteRepository noteRepository;

  @GetMapping
  public String main(Map<String, Object> model){
    Iterable<Note> notes = noteRepository.findAll();
    model.put("notes", notes);
    return "main";
  }

  @PostMapping
  public String addNote(@RequestParam String name,
      @RequestParam String desc,  Map<String, Object> model) {
    noteRepository.save(new Note(name, desc));
    Iterable<Note> notes = noteRepository.findAll();
    model.put("notes", notes);
    return "main";
  }
}
