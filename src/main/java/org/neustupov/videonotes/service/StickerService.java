package org.neustupov.videonotes.service;

import java.util.ArrayList;
import java.util.Optional;
import org.neustupov.videonotes.model.Board;
import org.neustupov.videonotes.model.Sticker;
import org.neustupov.videonotes.repo.BoardRepository;
import org.neustupov.videonotes.repo.StickerRepository;
import org.neustupov.videonotes.to.StickerTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StickerService {

  private BoardRepository boardRepository;

  private StickerRepository stickerRepository;

  @Autowired
  public StickerService(BoardRepository boardRepository, StickerRepository stickerRepository) {
    this.boardRepository = boardRepository;
    this.stickerRepository = stickerRepository;
  }

  public Sticker save(StickerTo stickerTo){
    Board board = boardRepository.findById(stickerTo.getBoardId()).orElseThrow(IllegalArgumentException::new);
    Sticker sticker = stickerRepository.save(new Sticker(stickerTo.getTitle(), new ArrayList<>(),
        new ArrayList<>(), board));
    board.getStickers().add(sticker);
    return sticker;
  }
}
