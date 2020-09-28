package org.neustupov.videonotes.repo;

import org.neustupov.videonotes.model.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {

}
