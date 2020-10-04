package org.neustupov.videonotes.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.neustupov.videonotes.model.Board;
import org.neustupov.videonotes.model.Sticker;
import org.neustupov.videonotes.repo.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
  public ResponseEntity<List<Board>> getAllBoards(@RequestParam(required = false) String title) {
    try {
      List<Board> boards = new ArrayList<>();

      if (title == null)
        boards.addAll(boardRepository.findAll());
      else
        boards.addAll(boardRepository.findByTitleContaining(title));

      if (boards.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(boards, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/boards/{id}")
  public ResponseEntity<Board> getBoardById(@PathVariable("id") long id) {
    Optional<Board> boardData = boardRepository.findById(id);

    return boardData.map(board -> new ResponseEntity<>(board, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/boards/{id}/stickers")
  public ResponseEntity<List<Sticker>> getBoardTickets(@PathVariable("id") long id){
    Optional<Board> boardData = boardRepository.findById(id);
    List<Sticker> stickers = boardData.orElse(new Board()).getStickers();
    return stickers.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(stickers, HttpStatus.OK);
  }

  @PostMapping("/boards")
  public ResponseEntity<Board> createBoard(@RequestBody Board board) {
    try {
      Board _board = boardRepository
          .save(new Board(board.getTitle(), new ArrayList<>()));
      return new ResponseEntity<>(_board, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/boards/{id}")
  public ResponseEntity<Board> updateTutorial(@PathVariable("id") long id, @RequestBody Board board) {
    Optional<Board> boardData = boardRepository.findById(id);

    if (boardData.isPresent()) {
      Board _board = boardData.get();
      _board.setTitle(board.getTitle());
      return new ResponseEntity<>(boardRepository.save(_board), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/boards/{id}")
  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
    try {
      boardRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/boards")
  public ResponseEntity<HttpStatus> deleteAllTutorials() {
    try {
      boardRepository.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
