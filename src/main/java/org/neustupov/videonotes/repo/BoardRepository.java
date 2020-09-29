package org.neustupov.videonotes.repo;

import java.util.List;
import org.neustupov.videonotes.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {

  List<Board> findByNameContaining(String name);
}
