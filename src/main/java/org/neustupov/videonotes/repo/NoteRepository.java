package org.neustupov.videonotes.repo;

import org.neustupov.videonotes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
