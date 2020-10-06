package org.neustupov.videonotes.service;

import java.util.ArrayList;
import org.neustupov.videonotes.model.Note;
import org.neustupov.videonotes.model.Sticker;
import org.neustupov.videonotes.repo.NoteRepository;
import org.neustupov.videonotes.repo.StickerRepository;
import org.neustupov.videonotes.to.NoteTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

  private NoteRepository noteRepository;
  private StickerRepository stickerRepository;

  @Autowired
  public NoteService(NoteRepository noteRepository, StickerRepository stickerRepository) {
    this.noteRepository = noteRepository;
    this.stickerRepository = stickerRepository;
  }

  public Note save(NoteTo noteTo){
    Sticker sticker = stickerRepository.findById(noteTo.getStickerId()).orElseThrow(IllegalArgumentException::new);
    Note note = noteRepository.save(new Note(noteTo.getDescription(), sticker));
    sticker.getNotes().add(note);
    return note;
  }
}
