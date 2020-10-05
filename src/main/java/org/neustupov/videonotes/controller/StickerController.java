package org.neustupov.videonotes.controller;

import java.util.Optional;
import org.neustupov.videonotes.model.Sticker;
import org.neustupov.videonotes.repo.StickerRepository;
import org.neustupov.videonotes.service.StickerService;
import org.neustupov.videonotes.to.StickerTo;
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
public class StickerController {

  private final StickerService stickerService;
  private final StickerRepository stickerRepository;

  @Autowired
  public StickerController(StickerService stickerService, StickerRepository stickerRepository) {
    this.stickerService = stickerService;
    this.stickerRepository = stickerRepository;
  }

  @PostMapping("/stickers")
  public ResponseEntity<Sticker> createSticker(@RequestBody StickerTo stickerTo) {
    try {
      Sticker _sticker = stickerService.save(stickerTo);
      return new ResponseEntity<>(_sticker, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/stickers/{id}")
  public ResponseEntity<Sticker> updateSticker(@PathVariable("id") long id,
      @RequestBody Sticker sticker) {
    Optional<Sticker> stickerData = stickerRepository.findById(id);

    if (stickerData.isPresent()) {
      Sticker _sticker = stickerData.get();
      _sticker.setTitle(sticker.getTitle());
      return new ResponseEntity<>(stickerRepository.save(_sticker), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
