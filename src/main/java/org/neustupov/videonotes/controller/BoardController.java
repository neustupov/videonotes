package org.neustupov.videonotes.controller;

import java.util.ArrayList;
import java.util.List;
import org.neustupov.videonotes.model.Board;
import org.neustupov.videonotes.repo.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:8082"})
@RestController
@RequestMapping("/api")
public class BoardController {

  private final BoardRepository boardRepository;

  @Autowired
  public BoardController(BoardRepository boardRepository) {
    this.boardRepository = boardRepository;
  }

  @GetMapping("/boards")
  public ResponseEntity<List<Board>> getAllTutorials(@RequestParam(required = false) String name) {
    try {
      List<Board> boards = new ArrayList<>();

      if (name == null)
        boards.addAll(boardRepository.findAll());
      else
        boards.addAll(boardRepository.findByNameContaining(name));

      if (boards.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(boards, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/boards")
  public ResponseEntity<Board> createBoard(@RequestBody Board board) {
    try {
      Board _board = boardRepository
          .save(new Board(board.getName(), new ArrayList<>()));
      return new ResponseEntity<>(_board, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
